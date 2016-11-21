package scalaTest.testFlatSpec

/**
  * Created by e797240 on 18/11/2016.
  */
package object learnFlatSpec {

  trait Number {
    def number: String

    require(number forall Character.isDigit, "Unable to convert string to number")
    //require(number.forall(Character.isDigit(_)),"Unable to convert string to number")
    //require(number.forall((a)=>Character.isDigit(a)),"Unable to convert string to number")
  }

  case class Decimal(number: String) extends Number

  case class Binary(number: String) extends Number

}

object BaseConversion {

  import scala.annotation.tailrec
  import scalaTest.testFlatSpec.learnFlatSpec.{Binary, Decimal}

  def bianryToDecimal(binary: Binary): Decimal = {
    val seq = binary.number.reverse.zipWithIndex.map { case (a, i) => a.toString.toInt * math.pow(2, i) }
    Decimal(seq.sum.toInt.toString)
  }


  def decimalToBinary(decimal: Decimal) = {
    Binary(toBinary(BigInt(decimal.number), "").toString)
  }

  @tailrec
  private def toBinary(num: BigInt, acc: String): String = {
    if (num < 2) (num.toString + acc)
    else toBinary(num / 2, (num mod 2).toString ++ acc)
  }
}