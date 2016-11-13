package map

/**
  * Created by E797240 on 13/11/2016.
  */
class SimpleMonads {

}

object SimpleMonads {
  def main(sda : Array[String]): Unit = {
    val i : Int = 1;
    val oSome : Option[Int] = Some(4 : Int)
    val oNone : Option[Int] = None
    println(oSome.getOrElse(0)+oNone.getOrElse(0))
  }
}
