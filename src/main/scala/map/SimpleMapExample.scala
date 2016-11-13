package map
import java.util.Calendar

/**
  * Created by e797240 on 11/11/2016.
  */
class SimpleMapExample {
  //We shall use this as a map function
  def age(birthYear : Int) :Int = {
    Calendar.getInstance().get(Calendar.YEAR) - birthYear
  }
}

object SimpleMapExample {
  def main(args : Array[String]): Unit = {
    val mapExample :SimpleMapExample = new SimpleMapExample()
    val birthyears = List(1975, 1978, 2011, 2013)
    val ageYears = birthyears.map(mapExample.age) //Note the age representation does not take an arg, although it is specified with one
    println(birthyears)
    println(ageYears)
    println(birthyears.map(year => Calendar.getInstance().get(Calendar.YEAR)-year))
    println(birthyears.map(Calendar.getInstance().get(Calendar.YEAR)- _))
  }
}