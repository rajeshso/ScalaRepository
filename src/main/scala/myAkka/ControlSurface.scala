package myAkka

import akka.actor.{Actor, ActorRef}
import myAkka.Altimeter.RateChange
import myAkka.ControlSurface.{StickBack, StickFront}

/**
  * Created by e797240 on 02/12/2016.
  */
object ControlSurface {

  case class StickBack(amount: Float)

  case class StickFront(amount: Float)

}

class ControlSurface(altimeter: ActorRef) extends Actor {
  override def receive: Receive = {
    case StickBack(amount: Float) => altimeter ! RateChange(amount)
    case StickFront(amount: Float) => altimeter ! RateChange(-1 * amount)
  }
}
