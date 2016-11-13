package inheritance.concretefieldsontraits

/**
  * Created by E797240 on 03/11/2016.
  */
trait Counter {
  var count = 0
  def increment()
}

class IncrementByOne extends Counter {
  override def increment() : Unit = {
    count+=1
  }
}

object IncrementByOne {
  def main(sdfs : Array[String]): Unit =  {
    var inc1 : IncrementByOne = new IncrementByOne()
    var inc2 : IncrementByOne = new IncrementByOne()
    inc1.increment()
    inc2.increment()
    inc2.increment()
    println(inc1.count)
    println(inc2.count)
  }
}

//Abstract Fields on Traits
trait AbsCounter {
  var count : Int
  def increment()
}

class IncrementAbsCounter extends AbsCounter {
  var count = 1 //forced to supply a value, Also override is optional for both fields and methods
  override def increment() : Unit = count+=1
}