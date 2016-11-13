package fakeFunction

/**
  * Created by E797240 on 08/11/2016.
  */
class Directory {
 private val numbers = scala.collection.mutable.Map(
   "Amitabh" -> "1234565",
   "Aishwarya" -> "7890",
   "Abhishek" -> "1111"
 )
  def apply(name : String) = numbers(name)

  def update(name: String, number : String): Unit = {
    numbers.update(name, number)
  }
  // Another example of overloaded update
  def update(areaCode : Int, newAreaCode : String): Unit = {
    numbers.foreach(entry => {
      if (entry._2.startsWith(areaCode.toString)) {
        numbers(entry._1) = entry._2.replace(areaCode.toString, newAreaCode)
      }
    })
    //you can have as many values as required in the update method, but the last arg is used as the method to be updated.
    //The rest are used to select the update method
    //_1 and _2 are tuples. They represent Map.Entry's getKey() and getValue()
  }
   override def toString = numbers.toString
}
object Directory {
  def main(asdas : Array[String]): Unit = {
    val yellowPages = new Directory()
    println("Amitabh = "+ yellowPages("Amitabh"))

    yellowPages("Aishwarya") = "2222"
    println("Aishwarya = "+ yellowPages("Aishwarya"))

    yellowPages.update("Aishwarya","33333")
    println("Aishwarya = "+ yellowPages("Aishwarya"))

    yellowPages("3") = "444444444"//No effect

    // Another example of overloaded update- this is the way to call
    print("Before = "+ yellowPages)
    yellowPages(11) = "22"
    println("After = "+ yellowPages)
  }
}
