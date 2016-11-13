

package pack3
import scala.math.Ordered

class Customer(val name : String, val address : String) extends Ordered[Customer] {
  def compare(that: Customer): Int = {
    name.compareTo(that.name)
  }
  override def toString : String = {
    "( "+ name + " " + address + " )"
  }
}