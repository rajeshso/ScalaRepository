package scalatest
import org.scalactic.StringNormalizations.lowerCased
import org.scalatest.Matchers.convertToAnyShouldWrapper
import org.scalatest.{FlatSpec, MustMatchers}
/**
  * Created by E797240 on 15/11/2016.
  */
class TestFlatSpec extends FlatSpec with MustMatchers  {

  "An empty Set" should "have size 0" in {
    assert(Set.empty.size == 0)
  }

  "ABCDEF" should "HIJKLMN" in {
    assert(Set.empty.size == 0)
  }

  "kjhlkh".should("HIJKLMN").in {
    "Hi" should equal ("hi") (after being lowerCased)
    val result = 3
    result should equal (3)

    assert(Set.empty.size == 0)
  }

  it should "produce NoSuchElementException when head is invoked" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }

  it should "dsfsdf" in {
    val list = 1::2::Nil
    list.size should be (2)
  }

}
