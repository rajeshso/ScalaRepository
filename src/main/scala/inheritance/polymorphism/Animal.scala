package inheritance.polymorphism

/**
  * Created by e797240 on 03/11/2016.
  */
class Animal {
  def move: Unit = {
    println("Animal moves")
  }
}

trait HasWings extends Animal {
  override def move: Unit = {
    //super.move
    println("Flaps up and down")
  }
}

trait Bird extends HasWings {
  override def move: Unit = {
    //super.move
    println("Bird Flaps up and down")
  }
}

trait HasFourLegs extends Animal {
  override def move: Unit = {
    //super.move
    println("Walks forward and backward")
  }
}
//the last of the With is the one that is finally overriden
class FlyingHorse extends Animal with Bird with HasFourLegs {

}
//the last of the With is the one that is finally overriden
class FlyingHorse1 extends Animal with HasFourLegs with Bird  {

}
object FlyingHorse {
  def main(sdf : Array[String]): Unit = {
    var f : FlyingHorse = new FlyingHorse
    f.move
    println("------------")
    var f1 = new FlyingHorse1
    f1.move
  }
}