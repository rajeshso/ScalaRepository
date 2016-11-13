package patternMatching

/**
  * Created by E797240 on 11/11/2016.
  */
class GuardConditions {

}
object GuardConditions {
  def main(args : Array[String]): Unit = {
    val student = new Student("Nithilan","2")
    student.id match {
      case student.id if student.id == "2" => println(student.name);
      case _ => println("Incorrect input")
    }
  }
}