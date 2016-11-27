package scalatest

import org.scalatest.{FlatSpec, Inside, Inspectors, Matchers, OptionValues}

/**
  * This base class is suggested to be extended. This helps to avoid inheriting duplicated traits
  */
abstract class UnitSpec extends FlatSpec with Matchers with OptionValues with Inside with Inspectors {

}
