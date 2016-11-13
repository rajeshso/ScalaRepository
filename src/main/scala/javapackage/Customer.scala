package javapackage

class Customer(val id:String, val name:String, secret:Int, private var privateStr:Int) {
  var pincode = "";
  private var _address = ""

  def address = _address;//getter
  def address_=(value:String) { //setter. note the _= spacing
    if (_address.isEmpty())
      _address = value;
  }
  //NOte
  //For val, only getter is generated and not setter
  //For var, both getter and setter are generated. setter is _eq and getter is just the name()
  //secret variable is not visible inside the constructor. its a none type
  //private generates only private getter and setter methods
}
object Customer {
  def main(args: Array[String]) {
    val rajesh = new Customer("007", "Rajesh", 12, 12)
    rajesh.pincode_$eq("1234"); //acceptable setter
    rajesh.pincode = "4321"; // acceptable setter
    //rajesh.pincode_="1111"; //compiler error // incorrect setter
    rajesh.pincode_=("2222"); //acceptable setter _= is taken as _eq
    //rajesh.pincode_ =(""); //compiler error setter because there is a space between _ and =
    rajesh.address = "3, Lathom"
    println(rajesh.id)
    println(rajesh.address)
    println(rajesh.pincode)
    println()
    //rajesh.pincode(); //Compiler error incorrect getter
  }
}