package inheritance.abstractclasses

/**
  * Created by E797240 on 03/11/2016.
  */
abstract class AbstractCounter {
 def total : Double
  def count : Int
}

//Note that there is no abstract keyword for methods
//The override keyword is optional for methods
class ConcreteCounter extends AbstractCounter {
  def total : Double = {
    45.00
  }
  override def count : Int = 12
}

