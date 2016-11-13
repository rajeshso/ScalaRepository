package map

/**
  * Created by E797240 on 13/11/2016.
  */
class Monad {

}

class Person(val name: String, val worth : Int)

class PersonSet extends Iterable[Person] {
  val persons = Set(new Person("John", 900), new Person("Cara", 100), new Person("Mike", 500))

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
  }
}