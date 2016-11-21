package scalatest

import org.scalatest.FlatSpec;

/**
  * Created by E797240 on 21/11/2016.
  */
class DecimalBinarySpec extends FlatSpec {
  "base conversion utility" should "convert a number 99 into a binary number 1100011" in {
    import scalaTest.testFlatSpec.BaseConversion
    import scalaTest.testFlatSpec.learnFlatSpec.{Binary, Decimal}
    val binary: Binary = BaseConversion.decimalToBinary(Decimal("99"))
    assert(binary.number == "1100011")
  }
}
