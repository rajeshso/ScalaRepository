package map

/**
  * Created by e797240 on 16/11/2016.
  */
class SimpleOption1 {
  def findRaj(name: String) : Option[String] = {
    var result : Option[String] = None
    if (name == "Rajesh")
      Some("Raj")
    else
      None
  }
}

object SimpleOption1 {

  import scala.collection.mutable.Set

  private val passedNames = Set("Rajesh")
  private val notPassedNames = Set("ABCD")
  def main(asasd : Array[String]): Unit = {
    val simpleMonad : SimpleOption1 = new SimpleOption1()
    val result1 : Set[Option[String]] = passedNames.map(simpleMonad.findRaj)
    val result2 : Set[Option[String]] = notPassedNames.map(simpleMonad.findRaj)
    println()
    result1.foreach(i => print(i.getOrElse("XYZ")))
    println()
    result2.foreach(i => print(i.getOrElse("XYZ")))
  }
}
