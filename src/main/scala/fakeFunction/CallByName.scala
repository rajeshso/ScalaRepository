package fakeFunction

/**
  * Typically, parameters to functions are by-value parameters; that is, the value of the parameter is determined before
  * it is passed to the function. But what if we need to write a function that accepts as a parameter an expression that
  * we don't want evaluated until it's called within our function? For this circumstance, Scala offers call-by-name
  * parameters.
  */
class CallByName {
    def printFiveNumbers(i : Int): Unit = {
      (i to i+4).foreach{println(_)}
    }

  //Traditional way
/*    def printThread(): Unit = {
      new Thread() {
        override def run() : Unit = printFiveNumbers(10)
      }.start()

      new Thread() {
        override def run(): Unit = printFiveNumbers(1)
      }.start()
    }*/

  //New way - Use Call by Name parameter - printFiveNumbers
  def printThread(): Unit = {
    //runInThread(()=>printFiveNumbers(10))
    runInThread(()=>printFiveNumbers(10))
    runInThread{
      printFiveNumbers(1) //Rememeber that the function is not executed here. It is executed in the run method
      printFiveNumbers(20)
    }
  }
  //def runInThread(myFunction : () => Unit): Unit = {
  def runInThread(myFunction :  => Unit): Unit = {
    new Thread() {
      //override def run() : Unit = myFunction()
      override def run() : Unit = myFunction
    }.start()
  }

}
object CallByName {
  def main(as : Array[String]): Unit = {
    val callByName : CallByName = new CallByName()
    //callByName.printFiveNumbers(5)
    callByName.printThread()
  }
}
