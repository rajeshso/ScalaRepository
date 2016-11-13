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
