package fakeFunction

/**
  * Created by E797240 on 10/11/2016.
  */
class Currying {
  //Uncurried function to add two numbers
  def add1(x: Int, y: Int) : Int = x + y

  //curried function to add two numbers
  def add2(x: Int)(y: Int) = x+y


}

object Currying {
  def main(asd : Array[String]): Unit = {
    val currying = new Currying()
    println(currying.add1(1,2))
    println(currying.add2(1)(2))
    //The best use of curried function
    val f1 = currying.add2(1)_
    println(f1(2))
  }
}
