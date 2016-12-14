package myAkka

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import myAkka.Plane.GiveMeControl

/**
  * Created by e797240 on 02/12/2016.
  */
object Plane {

  case object GiveMeControl

}

class Plane extends Actor with ActorLogging {
  val altimeter: ActorRef = context.actorOf(Props[Altimeter], "Altimeter")
  val controls: ActorRef = context.actorOf(Props(new ControlSurface(altimeter)), "ControlSurface")

  override def receive: Receive = {
    case GiveMeControl => {
      log info "Plane giving control"
      sender ! controls
    }
  }
}