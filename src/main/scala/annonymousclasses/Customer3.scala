package annonymousclasses

/**
  * Created by E797240 on 02/11/2016.
  */
class Customer3(val name : String, val address : String) {
  def addPoints(point : Point): Unit = {
    println(point.id)
  }
}

class Point(val id : String) {
  def myId : Int = {
    100
  }
}

object Customer3 {
  def main(args : Array[String]) : Unit = {
    val c : Customer3 = new Customer3("Rajesh","London")
    c.addPoints(new Point("A"))
    c.addPoints(new Point("B") {
      override def myId = 120
    })
  }
}