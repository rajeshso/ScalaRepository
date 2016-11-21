package scalatest

import org.scalatest.FunSuite

/**
  * Created by e797240 on 18/11/2016.
  */
class HelloTest extends FunSuite {
  test("displaySalutation should return 'Hello World'") {
    import scalaTest.Hello
    assert(Hello.displaySalutation() == "Hello World")
  }
}
