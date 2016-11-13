package controlstructures

/**
  * Created by E797240 on 03/11/2016.
  */
object Loop {
  def main(dsfa : Array[String]): Unit = {
    var i : Int = 0
    println("do..while")
    do {
      print(i)
      i+=1
    }while(i<5)

    println("\nwhile")
    i = 0;
    while(i<5) {
      print(i)
      i+=1
    }
    println("\nforeach with placeholder")
    (0 to 5).foreach(print(_))
    println("\nforeach with int=>expression")
    (0 to 5).foreach(i => print(i))
    println("\nfor comprehension")
    for(i <- 0 to 5) print(i) // <- is the feeder into the variable
    println("\nfor comprehension with method like .")
    for(i <- 0.to(5)) print(i)
    //breakable
    println("\nbreakable and break loop")
    import scala.util.control.Breaks.break
    import scala.util.control.Breaks.breakable
    breakable {
      for(i <- 0 to 5) {
        print(i)
        if (i==3)
          break()
      }
    }
    //Exceptions
    import java.net.URL
    import java.net.MalformedURLException
    import java.io.BufferedReader
    import java.io.InputStreamReader
    import java.io.IOException
    try {
      val url = new URL("http://www.google.co.uk/")
      val reader = new BufferedReader(new InputStreamReader(url.openStream()))
      try {
        val line = reader.readLine
        while (line != null)
          println(line)
      }finally {
        reader.close
      }
    }catch { //Note the curly braces
      case _ : MalformedURLException => println("Bad URL")
      case e : IOException => println("Something wrong with IO")
    }
  }
}
