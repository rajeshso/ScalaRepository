package scalatest

import org.scalatest.{FlatSpec, ShouldMatchers}

/**
  * Created by E797240 on 18/11/2016.
  */
class MatcherSpec extends FlatSpec with ShouldMatchers {

  "Baby Steps To Matchers" should "make me a TDD expert" in {
    import annonymousclasses.Customer3
    val message = "Hello World"
    message.should(equal("Hello World"))
    message should equal("Hello World")

    //ScalaTest Matchers provide five different ways to check for equality:
    message should be("Hello World")
    message shouldBe "Hello World"
    message should equal("Hello World")
    message shouldEqual ("Hello World")
    message should ===("Hello World")

    //To check if an object is an instance of a class, you can use be a or be an:
    message shouldBe a[String]
    message shouldBe an[String]
    message should not be a[HelloTest]

    val names = Seq("Rajesh", "Nimalan", "Nithilan")
    names shouldBe a[Seq[_]]
    names shouldBe a[Seq[String]]
    names should have size (3)
    names should have size 3
    message should have length 11

    names(0) should have length 6
    names.head should have length 6
    names.head should startWith("R")
    names should contain("Nimalan")

    val number = 26
    number should be > 25

    val war = true
    val over = true
    war shouldBe over

    val map = Map("one" -> 1, "two" -> 2)
    map should (contain key ("two") and not contain value(7))

    val customer3 = new Customer3("Rajesh", "lathom")
    customer3 should have {
      'name ("Rajesh")
      'address ("lathom")
    }

  }
}
