package pack3
import scala.collection.mutable.Set


class Customers extends Sortable[Customer] {
  private val customerSet = Set[Customer]()

  def add(customer : Customer) {
    customerSet.add(customer)
  }
  def iterator: Iterator[Customer] = {
    customerSet.iterator
  }
}