package implicits

/**
  * Created by e797240 on 17/11/2016.
  */
class ImplicitExample {
  implicit val code1 = 7
  implicit val greeting = "Hello"
  def greet(implicit greeting: String, code1: Int): Unit =  {
    println(greeting + " " + code1)
  }
  implicit val currentTaxRate = 0.08F
  def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate
  def calc(): Unit = {
    val tax = calcTax(50000F) // 4000.0
  }
}
object ImplicitExample {
  def main(asd : Array[String]): Unit = {
    val implicitExample : ImplicitExample = new ImplicitExample()
    implicitExample.calcTax(1212F)(12F)
  }
}