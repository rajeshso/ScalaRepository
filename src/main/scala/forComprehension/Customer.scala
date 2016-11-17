package forComprehension

/**
  * Generate a shipping label for a customer
  * The caveats are:
  * 1. A customer may or may not exist in the repository.
  * 2. A given customer may or may not have an address object.
  * 3. An address object must contain a street but may or may not contain a postcode.
  */
class Customer(val name: String, val address: Option[Address])

class Address(val street: String, val postCode: Option[String])

object CustomerRepo {

  import scala.collection.mutable

  val customers = mutable.Set[Customer]()

  def fillCustomers: Unit = {
    val customer1: Customer = new Customer("Rajesh", None)
    val customer2: Customer = new Customer("Nimalan", Some(new Address("Lathom", None)))
    val customer3: Customer = new Customer("Nithilan", Some(new Address("Lathom", Some("AB 1234"))))
    customers.add(customer1)
    customers.add(customer2)
    customers.add(customer3)
  }

  def find(name: String): Option[Customer] = {
    var result: Option[Customer] = None
    import scala.util.control.Breaks._
    breakable {
      for (customer <- customers) {
        if (customer.name == name) {
          result = Some(customer)
          break()
        }
      }
    }
    result
  }

}

object Example {
  def main(asd: Array[String]): Unit = {
    CustomerRepo.fillCustomers
    val names: Set[String] = Set("Rajesh", "Kathleen", "Nimalan", "Nithilan")
    //printTraditionalForEach(names)
    //printCompleteAddressUsingForEach(names)
    printCompleteAddressUsingForYield(names)
  }

  def printCompleteAddressUsingForYield(names: Set[String]): Unit = {
    for {
      name <- names //flatMap
      customer <- CustomerRepo.find(name) //flatMap
      address <- customer.address //flatMap
      postCode <- address.postCode //map
    } yield {
      println(customer.name)
      println(customer.address.get.street)
      println(customer.address.get.postCode.get)
    }
  }

  //Note that there is no if nonEmpty checks, because we are using flatMap
  def printCompleteAddressUsingForEach(names: Set[String]): Unit = {
    names.flatMap {
      name => {
        CustomerRepo.find(name).flatMap {
          customer => customer.address.flatMap {
            address => address.postCode.map {
              postCode => {
                println(customer.name)
                println(customer.address.get.street)
                println(customer.address.get.postCode.get)
              }
            }
          }
        }
      }
    }
  }

  def printTraditionalForEach(names: Set[String]): Unit = {
    names.foreach(name => {
      var customer: Option[Customer] = CustomerRepo.find(name)
      if (customer.nonEmpty) {
        println(customer.get.name)
        if (customer.get.address.nonEmpty) {
          print(customer.get.address.get.street)
          if (customer.get.address.get.postCode.nonEmpty) {
            print(customer.get.address.get.postCode.get)
          }
        }
        println()
      }
    })
  }
}


