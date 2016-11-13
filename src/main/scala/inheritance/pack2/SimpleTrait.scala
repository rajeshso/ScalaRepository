package inheritance.pack2

/**
  * Created by E797240 on 26/10/2016.
  */
import scala.collection.immutable.List
import scala.collection.immutable.Iterable
import scala.collection.mutable.Set
import inheritance.pack1.Customer

trait SimpleTrait {

}
//Ordered and Ordering are equivalents of Comparable
// A <: Ordered[A] means A extends Ordered
//B >: A means B super A
trait Sortable[A <: Ordered[A]] extends Iterable[A] {
  //default method in the trait
  def sort() : Seq[A]  = {
    this.toList.sorted
  }
}

class SortableCustomers extends Sortable[Customer] {
  private val customers = Set[Customer]()
  def add(customer: Customer) = customers.add(customer)
  def iterator : Iterator[Customer] = customers.iterator
}

class SortableCustomersByAddress extends SortableCustomers {
/*  override def sort() : Seq[Customer] = {
    this.toList.sorted(new Ordering[Customer] {
      def compare(a: Customer,b : Customer) = a.address compare b.address
    })
  }*/

  //Converting Anonymous Classes to Lambdas
  implicit def tryAnnonymousToLamda[A] (myFunction: (A,A) => Int) : Ordering[A] = {
    new Ordering[A] {
      def compare(a: A, b: A) = myFunction.apply(a,b)
    }
  }
  override def sort() : Seq[Customer] = {
    this.toList.sorted((a: Customer, b: Customer)=> a.address compare(b.address))
  }
}

object SortableCustomers {
  def main(args : Array[String]): Unit = {
    val sortableCustomers = new SortableCustomers()
    sortableCustomers.add(new Customer("Rajesh", "London"))
    sortableCustomers.add(new Customer("Nimalan", "London"))
    sortableCustomers.add(new Customer("Nithilan", "London"))
    println(sortableCustomers.sort())

    val sortableCustomersByAddress = new SortableCustomersByAddress()
    sortableCustomersByAddress.add(new Customer("Rajesh", "0London"))
    sortableCustomersByAddress.add(new Customer("Nimalan", "1London"))
    sortableCustomersByAddress.add(new Customer("Nithilan", "2London"))
    println(sortableCustomersByAddress.sort())
    println(sortableCustomersByAddress.tryAnnonymousToLamda((a:Customer, b:Customer) => a.name compare b.name))
  }
}