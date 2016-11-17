package map

/**
  * Created by E797240 on 13/11/2016.
  */
class Monad {

}

class Person(val name: String, val worth : Int)

class PersonSet extends Iterable[Person] {
  val persons = Set(new Person("John", 900), new Person("Cara", 100), new Person("Mike", 500), new Person("Ramesh",200), new Person("Suresh",600))

  def find(name :String) : Option[Person] = {
    for(person <- persons) {
      if (person.name == name) return Some(person)
    }
    None
  }
  def iterator : Iterator[Person] = persons.iterator
}

object Monad {
  def main(args : Array[String]): Unit = {
    val personSet = new PersonSet()
    val totalWorthValue : Option[Int] = personSet.find("John").map(person => person.worth)
    val x: Int = totalWorthValue.getOrElse(0)
    println(x)
    val indianCustomers = Set("Ramesh","Suresh")
    val totalWorthOfIndianCustomers1 = indianCustomers.map(personSet.find(_).map(_.worth)).flatten.sum
    //todo: the solution with replaced .map and .flatten with .flatMap
    val totalWorthOfIndianCustomers2 = indianCustomers.flatMap(name=> personSet.find(name)).map(_.worth).sum
    println("totalWorthOfIndianCustomers1 = "+totalWorthOfIndianCustomers1)
    println("totalWorthOfIndianCustomers2 = "+totalWorthOfIndianCustomers2)
  }
}