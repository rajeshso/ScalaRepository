package scalatest

import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

//import org.scalamock.generated.GeneratedMockFactory

/**
  * Created by E797240 on 25/11/2016.
  */
class TestScalaMock extends FlatSpec with MockFactory {
  "Learn MockFunctions" should "" in {
    // Creates mock function which expects single Int parameters
    // and returns a String
    val m = mockFunction[Int, String]
    // Then we set expectation on this mock that it is called once
    // with parameter 86 and it returns "Eighty Six"
    m expects (86) returning "Eighty Six" once

    m expects (76) returning "Seventy Six" twice

    println(m.apply(86))
    println(m.apply(76))
    println(m.apply(76))
  }

  "Learn Proxy Functions" should "" in {

    //val customer3 = mock[Customer3]
    //val point = mock[Point]

  }
}
