package fakeFunction

/**
  * Created by E797240 on 08/11/2016.
  */
class Emp(name : String, address : String) {
  //2) Make method calls look like function calls
  def apply(id : Int) = id+name+address
}

/**
  * Uses of apply method
  * 1) factory methods
  * 2) Make method calls look like function calls
  * 3) Access Array values using its apply methods
  */
object Emp {
  //1) factory methods
  def apply(name : String, address : String) = new Emp(name, address)

  def apply(name : String) = new Emp(name, "No known address")

  def main(sdfsd : Array[String]): Unit = {
    //1) factory methods
    val e1 = Emp.apply("Tom","3 Lathom")
    val e2 = Emp("Tom", "3 Lathom")
    val e3 = new Emp("Tom","3 Lathom")
    val e4 = Emp.apply("Tom")

    //2) Make method calls look like function calls
    val e6 = new Emp("Tom", "3 Lathom")
    e6.apply(4)
    e6(4)

    //3) Access Array values using its apply methods
    val romanNumerals = Array("I", "II", "III", "IV", "V")
    for(i <- 0 to romanNumerals.length-1)
      print(i+" = "+romanNumerals(i)+" ") //apply method is used internally
    println()
    for(i <- 0 to romanNumerals.length-1)
      print(i+" = "+romanNumerals.apply(i)+" ")
    println()
    romanNumerals(2) = "TWO" //update method is used internally
    println(romanNumerals(2))
    romanNumerals.update(3, "THREE")
    println(romanNumerals(3))
    //Move method calls to function call
    romanNumerals{2} = "TWO" //Notice the curve brackets are replaced with curly brackets
    //romanNumerals(val i=1; i) = "ONE" //Compile error with curve brackets
    romanNumerals{val i=1; i} = "ONE" //No error with curly brackets.
    // The expression, val i=1; i ,is a function. romanNumerals is now called a Higher Order Function because it has accepted
    //a function as an argument
    romanNumerals.foreach(println(_))
  }
}