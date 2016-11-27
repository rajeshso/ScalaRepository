package scalatest

import org.scalatest.FlatSpec

import scalaTest.testFlatSpec.BaseConversion
import scalaTest.testFlatSpec.learnFlatSpec.{Binary, Decimal}
/**
  * Created by E797240 on 21/11/2016.
  */
class DecimalBinarySpec extends FlatSpec {
  "base conversion utility" should "convert a number 99 into a binary number 1100011" in {

    val binary: Binary = BaseConversion.decimalToBinary(Decimal("99"))
    assert(binary.number == "1100011")
  }

  //it is equivalent to "base conversion utility" .pending means 'yet to be implemented'
  //it should "convert a number 245 into a binary number 11110101" in pending
  //"base conversion utility".should("convert a number 99 into a binary number 1100011").in({assert(1==1)})

  it should "convert a number 245 into a binary number 11110101" in {
    val binary: Binary = BaseConversion.decimalToBinary(Decimal("99"))
    assert(binary.number == "1100011")
  }

  //JUnit style of testing exceptions
  "Decimal" should "throw error when initialized with a non numeric string" in {
    try {
      Decimal("ABC")
    } catch {
      case e: IllegalArgumentException => assert(e.getMessage == "requirement failed: Unable to convert string to number")
      case _ => fail("Sorry! You would have to correct yourself")
    }
  }

  //Scalatest way of intercepting exceptions
  "Binary" should "throw error when initialized with a non numeric string" in {
    intercept[IllegalArgumentException] {
      Binary("ABC")
    }
  }

  "Binary" should "throw error when initialized with a non numeric string using withClue" in {
    withClue("The argument with incorrect input throws Exception") {
      //intercept[IllegalThreadStateException] {
      intercept[IllegalArgumentException] {
        Binary("ABC")
      }
    }
  }

  //Use assume as a precondition to execute the test - If the precondition fails, the test is cancelled, but not failed
  "Learn to assume" should "" in {
    val one = 1;
    assume(one == 1, "The assumption is incorrect")
    println("My assumption is correct")
    val two = 2
    assert(two == 2)
  }

}
