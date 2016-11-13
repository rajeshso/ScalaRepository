//Auxiliary Constructors and Companion Objects

package javapackage

//class MyCustomer(forename : String, initial: String ="", surname : String) { //in this case, the caller has to call with the names
class MyCustomer(forename : String, initial: String, surname : String) {
  val fullname = String.format("%s %s. %s", forename, initial, surname) //this will go into the java default cons

  //auxiliary constructor
  def this(forename : String, surname : String) {
    this(forename, "", surname)
  }
}

//If class and the object are specified in the same file, the object is called the Companion object
object MyCustomer {
  def main(args: Array[String]) {
    var cust = new MyCustomer("Rajesh", "A", "Somasundaram")
    //var cust1 = new MyCustomer("Rajesh", surname = "Somasundaram")
  }
}