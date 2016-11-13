package generics

/**
  * Created by e797240 on 04/11/2016.
  */
class BoundedGenerics {

}

class Animal (val age : Int) extends Comparable[Animal]{
  def compareTo(o : Animal): Int = {
    if (o.age > this.age) 0 else 1
  }
}
class Lion(age: Int) extends Animal(age) {}
class Zebra(age: Int) extends Animal(age) {}

object BoundedGenerics {
  def main(args : Array[String]): Unit = {
    //Lion enclosure
    var lionEnclosure : List[Lion] = List[Lion]()
    lionEnclosure = new Lion(10) +: lionEnclosure //remember to use +: to add list
    lionEnclosure = new Lion(20) +: lionEnclosure
    //sort(lionEnclosure)

    //Lion and Zebra Enclosure
    var lionZebraEnclosure : List[Animal] = List[Animal]()
    lionZebraEnclosure :+ new Lion(30) +: lionZebraEnclosure
    lionZebraEnclosure :+ new Zebra(21) +: lionZebraEnclosure
    sort(lionZebraEnclosure)

  }
//public static <A extends Comparable<? super A>> Unit sort(List<A> list
  def sort[A <: Comparable[A]](animals : List[A]): Unit = { //The definition of A has to be after the method name
    animals.sorted
  }
}