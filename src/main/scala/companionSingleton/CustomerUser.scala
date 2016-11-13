package companionSingleton

/**
  * Created by E797240 on 28/10/2016.
  */
class MyCustomer (val name : String) {
  val id : Int = MyCustomer.nextId
}

object MyCustomer {
  private var sequenceOfIds : Int = 0
  private def nextId() : Int = {
    sequenceOfIds+=1
    sequenceOfIds
  }
}

object CustomerUser  {
  def main(args: Array[String]): Unit = {
    var c : MyCustomer = new MyCustomer("Rajesh")
    println(c.name + " " + c.id)
    c = new MyCustomer("Nimalan")
    print(c.name + " " + c.id)
  }
}