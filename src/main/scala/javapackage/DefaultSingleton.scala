package javapackage

object DefaultSingleton { //Objects are singleton by default - Refer the decompiled file
def log(level: String, message: String ) { //Method is static by default
  printf("%s %s", level, message)
}
  def main(args: Array[String]) {// Scala does not have a static key word but the Method is static by default
    log("1", "This is a log message from my singleton object")
  }
}