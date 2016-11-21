package scalatest

import org.scalactic.Explicitly.after
import org.scalactic.StringNormalizations.lowerCased
import org.scalactic.TypeCheckedTripleEquals._

/**
  * Created by E797240 on 17/11/2016.
  */
class TestScalactic {

}

object TestScalactic {
  def main(asd: Array[String]): Unit = {
    //Some(1) === 2
    println(Some(1) === Some(2))
    //1 === 1L
    //1 === 1L
    //println(List(1, 2, 3) === Vector(1, 2, 3))
    //println(List(1, 2, 3) === Vector(1, 2, 3))
    //println(List(1, 2, 3) === Set(1, 2, 3))
    println(("Hello" === "hello") (after being lowerCased))

  }
}