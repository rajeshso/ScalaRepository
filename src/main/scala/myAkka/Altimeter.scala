package myAkka

import akka.actor.{Actor, ActorLogging}

import scala.concurrent.duration._

/**
  * Created by E797240 on 01/12/2016.
  */
object Altimeter {

  case class RateChange(amount: Float)

}

class Altimeter extends Actor with ActorLogging {

  import myAkka.Altimeter.RateChange

  implicit val executionContext = context.dispatcher
  val maxCeilingInFeet = 43000
  val rateOfClimbPerMinute = 5000
  var rateOfClimb: Float = 0f
  var currentAltitude: Double = 0d
  var lastTimeTick = System.currentTimeMillis
  // We need to periodically update our altitude. This
  // scheduled message send will tell us when to do that
  var ticker = context.system.scheduler.schedule(100.millis, 100.millis, self, Tick)

  override def receive: Receive = {
    case RateChange(amount) =>
      rateOfClimb = amount.min(1.0f).max(-1.0f) * rateOfClimbPerMinute
      log info s"Altimeter changed rate of climb to $rateOfClimbPerMinute."
    case Tick =>
      val tick = System.currentTimeMillis
      currentAltitude = currentAltitude + ((tick - lastTimeTick) / 60000.0) * rateOfClimb
      lastTimeTick = tick
  }

  override def postStop(): Unit = ticker.cancel

  case object Tick

}