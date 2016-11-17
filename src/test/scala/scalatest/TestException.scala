package scalatest

import org.scalatest.FunSuite

/**
  * Created by E797240 on 15/11/2016.
  */
class TestException extends FunSuite {
  test("Exception is expected and the exception is caught. PASSED") {
    val msg = "Hello"
    intercept[IndexOutOfBoundsException] { //This is equivalent to try...catch
      msg.charAt(-1)
    }
  }

  //TO demonstrate that test is a function
  /**
    * protected def test(testName: String, testTags: Tag*) (testFun: => Any) (implicit pos: Position): Unit = {}
    */
  val f = test("dfsfsd") _
  f {
    val msg = "Hello"
    intercept[IndexOutOfBoundsException] { //This is equivalent to try...catch
      msg.charAt(-1)
    }
  }

  test("Exception is expected and the exception is not thrown, FAILED") {
    val msg = "Hello"
    intercept[IndexOutOfBoundsException] {
      msg.charAt(2)
    }
  }

  ignore("Exception is expected and the exception is not thrown, FAILED") {
    val msg = "Hello"
    intercept[IndexOutOfBoundsException] {
      msg.charAt(2)
    }
  }
}
