var i=0
i+=2
i

def min(x : Int, y: Int) : Int = {
  if (x<y)
    x
  else
    y
}

min(4,2)

val age : Int = 10
age.* (0.5)
age*(0.5)
age * 0.5

age.toString()
age.toString
age toString

val myList = scala.collection.immutable.List("a","b","c")
val myMap = scala.collection.immutable.Map(1->"a", 2->"b", 3->"c")
myList.foreach(value => println())
myList.foreach(value => print(value))
myList.foreach(print)
for (i <- myList) { print(i)}

//Lambdas
//test that takes a Function that has no args but returns a Boolean
def test (MyFunction : () => Boolean) : Boolean = {
    true
}
test(() => if (1<2) true else false)

//test that takes a Function that takes a String as args and returns a Boolean
def test1 (MyFunction : String => Boolean) : Boolean = {
 MyFunction.apply("true")
}
test1(aVal => if (aVal == "false") true else false)

//for(int i=0;i<100;i++) System.out.println(i)
(0 to 10).foreach(print(_))
(0 to 10).foreach(i=>print(i))
(0 to 5).foreach{print(_)}

//Faking Function calls for an expressive scala

var myList2 = 2 :: 4 :: 5 :: 7 :: Nil
//myList2.size should equal (4)
//myList2 shoud have size 4

var message = "I am moving up"
//message should startWith ("I am ")

import java.util.Calendar

import org.scalactic.StringNormalizations._
import org.scalatest.Matchers._
"Hi" should equal ("hi") (after being lowerCased)

def age(birthYear : Int) : Int = {
  import java.util.Calendar
  Calendar.getInstance().get(Calendar.YEAR) - birthYear
}
var birthDays = List(1975, 1977, 2011, 2013)
//birthDays.map(age)

birthDays.map((i) => Calendar.getInstance().get(Calendar.YEAR) - i)
birthDays.map(i => Calendar.getInstance().get(Calendar.YEAR) - i)
birthDays.map(Calendar.getInstance().get(Calendar.YEAR) - _)

//One Input results In Multiple Output - OneToMany
def ages1(birthYear : Int) : List[Int] = {
  import java.util.Calendar
  var result = List(Calendar.getInstance().get(Calendar.YEAR) - birthYear - 1,Calendar.getInstance().get(Calendar.YEAR) - birthYear, Calendar.getInstance().get(Calendar.YEAR) - birthYear +1)
  result
}

birthDays.flatMap(ages1)

var seqInt :Seq[Int] = for(i <- 0 to 5) yield i
println(seqInt.size)

var seqDoubleInt : Seq[Int] = for(i <- 0 to 5) yield {i*2}
println(seqDoubleInt)

val aArray = Array(1,2,3,4,5)
val aArrayDoubled : Array[Int] = for(e <- aArray) yield e*2

