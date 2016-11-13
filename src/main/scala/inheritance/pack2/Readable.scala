package inheritance.pack2

/**
  * Created by E797240 on 26/10/2016.
  */
trait Readable {
  def total(value: Double) : Double
}

trait AnotherReadable {
  def anotherTotal(value: Double) : Double
}

class MyReadable extends Readable {

  def total(value : Double) : Double = {
    value * 2
  }
}

class MyAnotherReadable extends Readable with AnotherReadable {
  def total(value : Double) : Double = {
    value * 2
  }
  override def anotherTotal(value: Double) : Double = {
    value * 2
  }
}