package inheritance.mixins

/**
  * Odersky calls traits with behaviour (default methods and variables) as “mixin traits”.
  *
  * Problem
  * You want to design a solution where multiple traits can be mixed into a class to provide a robust design.
  * Solution
  * To implement a simple mixin, define the methods you want in your trait, then add the trait to your class using
  * extends or with. For instance, the following code defines a Tail trait:
  */
trait Tail {
  def wagTail: Unit = {
    println("tail is wagging")
  }
  def stopTail: Unit =  {
    println("tail is stopped")
  }
}

abstract class Pet (var name: String) {
  def speak //abstract
  def ownerIsHome: Unit = {
    println("excited")
  }
  def jumpForJoy: Unit = {
    println("jumping for joy");
  }
}

class Dog(name : String) extends Pet(name) with Tail {
  def speak: Unit = {
    println("woof")
  }
  override def ownerIsHome: Unit =
  {
    wagTail
    speak
    jumpForJoy
  }
}

object Dog {
  def main(asa : Array[String]): Unit = {
    var dog :Dog = new Dog("Zeus")
    dog.ownerIsHome
  }
}