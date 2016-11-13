package patternMatching

/**
  * Extractor extracts the object's constructor parameters
  */
class ExtractorExample {

}

class Student(val name: String, val id : String)

object Student {
  //Option is used to return more than one value. The 'more than one value' is called a Tuple.
  //Extractor pattern (unapply) can be used for PRIMARY CONSTRUCTOR ONLY
  def unapply(arg: Student): Option[(String, String)] = Some((arg.name),(arg.id))

  def main(args : Array[String]): Unit = {
    val student : Student = new Student("Nimalan", "1")
    student match {
      case Student(name, id) => println(name + " " + id) //This will only work if you have a unapply for the parameters
      case student: Student => println(student.id)
      case _ => println("Invalid Student");
    }
  }
}