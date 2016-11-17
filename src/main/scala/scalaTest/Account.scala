package scalaTest

/**
  * Created by E797240 on 15/11/2016.
  */
case class Account(name : String, created : String ="0") {
  def process = {
    Thread.sleep(20)
    true
  }
}

object Account {
  println("Rajesh applies to TDD to Scala development")
}