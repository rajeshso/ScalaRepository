package scalatest

import org.scalatest.FunSuite

/**
  * Created by E797240 on 15/11/2016.
  */
class Test01 extends FunSuite {
  test("Very Basic") {
    assert(1==1)
  }
  test("Another very basic") {
    assert("Hello" == "Hello")
  }

  test("pass") {
    assert(1===1)
  }
  test("fail and show diff, Note that we are using triple equal, === for the reporting info") {
      assert("Hello" === "Hi")
  }
}
