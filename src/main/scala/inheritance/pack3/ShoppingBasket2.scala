package inheritance.pack3
import scala.collection.mutable.MutableList
/**
  * Created by E797240 on 02/11/2016.
  */
class ShoppingBasket2 {
 var itemList = new MutableList[String]()

  def add(item : String): Unit = {
    itemList += item
  }

  def total() : Double = {
    100.00
  }
}

class Customer2 (val name : String, val address : String) {
  val basket : ShoppingBasket2 = new ShoppingBasket2()

  def add(item : String): Unit = {
    basket.add(item)
  }

  def total() : Double = basket.total()
}

//Note that there is no val or var in both the constructor call. the variable name is same to indicate super call chaining
//the super.total is not super().total
class DiscountedCustomer2(name : String, address : String) extends Customer2(name, address) {

  override def total() : Double = {
    super.total * 0.9
  }
}

object Customer2Runner {
  var customer2 : Customer2 = new Customer2("Rajesh", "London")
  customer2.add("Book: Scala in depth")
  println(customer2.total())

  var discountedCustomer2 : DiscountedCustomer2 = new DiscountedCustomer2("Raj", "London")
  discountedCustomer2.add("Book: Scala Puzzlers")
  println(discountedCustomer2.total())
}