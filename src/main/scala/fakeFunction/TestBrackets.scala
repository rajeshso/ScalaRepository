package fakeFunction

/**
  * Created by E797240 on 09/11/2016.
  */
class TestBrackets {
  def returnInt(i: Int) : Int = {i+1}

  def acceptInt(i:Int) {println(i)}
}

object TestBrackets {
  def main(asdf : Array[String]): Unit = {
    val testBrackets = new TestBrackets
    val j = testBrackets.returnInt(4)
    println(j)
    testBrackets.acceptInt(j)
    testBrackets.acceptInt(testBrackets.returnInt(4))
    testBrackets.acceptInt{4}
    testBrackets.acceptInt{4+1}
    testBrackets.acceptInt{ val i=4; i+2}
  }
}