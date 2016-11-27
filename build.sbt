name := "HelloWorld"

version := "1.0"

scalaVersion := "2.11.7"

//libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0"
//libraryDependencies += "org.scalactic" % "scalactic" % "2.2.6"
//libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
//libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.6" % "test"
//if you omit test, the scalatest can be used outside the src/test

libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test"