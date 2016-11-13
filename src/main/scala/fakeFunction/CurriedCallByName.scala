package fakeFunction

/**
  * Created by E797240 on 10/11/2016.
  */
class CurriedCallByName {
  def printFiveNumbers(i : Int): Unit = {
    (i to i+4).foreach{println(_)}
  }

  //Traditional Curry way - Use Call by Name parameter - printFiveNumbers
  def printThread1(): Unit = {
    runInThreadGroup1("TEN", printFiveNumbers(10))
    runInThreadGroup1( //Note that the outer brackets are curvy
      "OneAndTwenty",
      { // Note that the brackets are curly
        printFiveNumbers(1)
        printFiveNumbers(20)
      }
    ) //Note that the outer brackets are curvy
  }

  //(Traditional) Curried function - Takes an argument and a Function
  def runInThreadGroup1(group : String, myFunction :  => Unit): Unit = {
    new Thread(new ThreadGroup(group),new Runnable() {
      override def run() = myFunction
    }).start()
  }

  //Scala's advocated Curried function - Curry way - Use Call by Name parameter - printFiveNumbers
  def printThread2(): Unit = {
    runInThreadGroup2("TEN")( printFiveNumbers(10))
    runInThreadGroup2("OneAndTwenty") //Note the usage
      {
        printFiveNumbers(1)
        printFiveNumbers(20)
      }

  }
  //Scala's advocated Curried function
  def runInThreadGroup2(group : String) (myFunction :  => Unit): Unit = {
    new Thread(new ThreadGroup(group),new Runnable() {
      override def run() = myFunction
    }).start()
  }
}

object CurriedCallByName {
  def main(sd : Array[String]): Unit = {
    val curriedCallByName = new CurriedCallByName()
    curriedCallByName.printThread1()
  }
}