package myAkka

import akka.actor.Actor
import akka.actor.{ActorRef, ActorSystem}

/**
  * Created by E797240 on 01/12/2016.
  */
case class Alpha(b1: Beta, g1: Gamma)

case class Beta(s1: String)

case class Gamma(s1: String)

class LearnDifferentMessages extends Actor {
  override def receive: Receive = {
    case s1: String => println(s"You sent me $s1")
    case i: Int => println(i)
    case a: Alpha => println(s"Alpha $a")
    case b: Beta => println(s"Beta $b")
  }
}

object LearnDifferentMessages {

  import akka.actor.Props

  val system = ActorSystem("LearntoSendDifferentMessages")
  val actorRef: ActorRef = system.actorOf(Props[LearnDifferentMessages], "Learner")

  def main(dfsd: Array[String]): Unit = {
    sendString
    sendInt
    sendAlpha
    sendBeta
    system.terminate
  }

  def sendString: Unit = {
    actorRef ! "Hello"
  }

  def sendInt: Unit = {
    actorRef ! 42
  }

  def sendAlpha: Unit = {
    actorRef ! new Alpha(new Beta("Hi1"), new Gamma("Hi2"))
  }

  def sendBeta: Unit = {
    actorRef ! new Beta("Hi3")
  }
}
