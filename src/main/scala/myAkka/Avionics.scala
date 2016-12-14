package myAkka

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by e797240 on 02/12/2016.
  */
object Avionics {
  //needed for ? below
  implicit val timeout: Timeout = Timeout(5.seconds)
  val system: ActorSystem = ActorSystem("PlaneSimulation")
  val plane: ActorRef = system.actorOf(Props[Plane], "Plane")

  def main(args: Array[String]) {
    //grab the controls
    val control: ActorRef = Await.result((plane ? Plane.GiveMeControl).mapTo[ActorRef], 5.seconds)
    //takeoff!
    system.scheduler.scheduleOnce(200.millis) {
      control ! ControlSurface.StickBack(1f)
    }
    // Level out
    system.scheduler.scheduleOnce(1.seconds) {
      control ! ControlSurface.StickBack(0f)
    }
    // Climb
    system.scheduler.scheduleOnce(3.seconds) {
      control ! ControlSurface.StickBack(0.5f)
    }
    // Level out
    system.scheduler.scheduleOnce(4.seconds) {
      control ! ControlSurface.StickBack(0f)
    }
    // Shut down
    system.scheduler.scheduleOnce(5.seconds) {
      system terminate
    }
  }
}
