package inheritance.pack1

class c {

}

class ShoppingBasket {
  def add(item: String) {
  }
  def total(value: Double) = {
    value*2;
  }
}
class Customer(val name: String, val address: String) extends Ordered[Customer] {
  private final val basket : ShoppingBasket = new ShoppingBasket();

  def add(item: String) {
    basket.add(item)
  }
  def total(value: Double) = {
    basket.total(value)
  }
  //this method is used to demonstrate ordering in inheritance.pack2.SortableCustomers
  def compare(that : Customer) : Int = {
    (this.name) compare (that.name)
  }
  override def toString() : String = name
}

//(name, address) at Customer indicates that we are calling the super class constructor
//Also, note that there is no val or var before the constructor fields
class DiscountedCustomer(name : String, address: String) extends Customer(name, address) {
  override def total(value: Double) = {
    super.total(value) * 0.9
  }
}