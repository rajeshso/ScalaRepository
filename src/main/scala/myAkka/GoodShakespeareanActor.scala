package myAkka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by E797240 on 30/11/2016.
  */
class GoodShakespeareanActor extends Actor {
  //Business logic is here
  override def receive: Receive = {
    case "Good Morning" => println("She: Wish you a good day")
    case "Good Evening" => println("She: Wish you a pleasant evening")
  }
}

object GoodShakespeareanActor {
  val system = ActorSystem("GoodShakespeareanActor")
  val actor = system.actorOf(Props[GoodShakespeareanActor], "Shakespeare")

  def main(asd: Array[String]): Unit = {
    send("Good Morning")
    send("Good Evening")
    system.shutdown()
  }

  def send(message: String): Unit = {
    println(s"Me: The message sent is $message")
    actor ! message
    Thread.sleep(100)
  }
}
