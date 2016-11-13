package map
import java.util.Calendar
/**
  * Created by e797240 on 11/11/2016.
  */
class SimpleFlatMapExample {
  //We shall use this as a flatmap function
  def ages(birthYear : Int) :List[Int] = {
    val today : Int = Calendar.getInstance().get(Calendar.YEAR)
    List(today-1-birthYear, today - birthYear, today+1 - birthYear)
  }
}
object SimpleFlatMapExample {
  def main(args : Array[String]): Unit = {
    val mapExample :SimpleFlatMapExample = new SimpleFlatMapExample()
    val birthyears = List(1975, 1978, 2011, 2013)
    val ageYears : List[Int] = birthyears.flatMap(mapExample.ages) //Note the ages representation does not take an arg, although it is specified with one
    println(birthyears)
    println(ageYears)
    val today : Int = Calendar.getInstance().get(Calendar.YEAR)
    println(birthyears.flatMap(birthYear => List(today-1-birthYear, today-birthYear, today+1-birthYear)))
    println(birthyears.map(birthYear => List(today-1-birthYear, today-birthYear, today+1-birthYear))) //Note the difference in output for flatMap and Map
  }
}