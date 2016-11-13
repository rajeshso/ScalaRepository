package controlstructures

/**
  * Switch functionality is achieved using Match Expressions
  */
object Switch {
  def main(dsfdsf : Array[String]): Unit = {
    val month = "April"
    var quarter = "???"
    //Note that there is no break statement, but break is implicit (automatic)
    month match {
      case "January" | "Februrary" | "March" => quarter = "1'st Quarter"
      case "April" => quarter = "2'nd Quarter"
      case "May" => quarter = "2'nd Quarter"
      case "June" => quarter = "2'nd Quarter"
      case "July" => quarter = "3'rd Quarter"
      case "August" => quarter = "3'rd Quarter"
      case "September" => quarter = "3'rd Quarter"
      case "October" => quarter = "4'th Quarter"
      case "November" => quarter = "4'th Quarter"
      case "December" => quarter = "4'th Quarter"
      case _ => quarter = "Unknown Quarter"
    }
    println(month + " is the "+ quarter)
  }
}