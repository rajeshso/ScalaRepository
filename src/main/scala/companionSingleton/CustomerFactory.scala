package companionSingleton

/**
  * this is to demostrate that CompanionFactory
  */
class GoodCustomer private (name : String) {
  def customerName = name
}
object GoodCustomer {
  def produceCustomer(name: String) : GoodCustomer = {
    val g = new GoodCustomer("Rajesh")
    g
  }
}

object GoodCustomerRunner {
  def main(args: Array[String]): Unit = {
    //var c : GoodCustomer = new GoodCustomer("Hello"); //private constructor is NOT accessible
    var d : GoodCustomer = GoodCustomer.produceCustomer("Rajesh")
    println(d.customerName)
  }
}
