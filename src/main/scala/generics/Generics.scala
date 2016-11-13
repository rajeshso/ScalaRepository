package generics

/**
  * Created by E797240 on 04/11/2016.
  */
class Generics {
  // public <A> add(A a) {} //Java
  def add[A](a: A) {
  }
}

/* //Java
  public interface Stack<T> {
    void push(T t);
    T pop();
  }*/
trait Stack[T] {
  def push(t: T)

  def pop(): T
}

class ListStack[T]() extends Stack[T] {
  private var elements: List[T] = List()

  override def push(t: T): Unit = {
    elements = t +: elements //the new element plus the rest of the elements
  }

  override def pop(): T = {
    if (elements.isEmpty)
      throw new IndexOutOfBoundsException
    val head = elements.head
    elements = elements.tail
    head
  }
}

object Generics {
  def main(sdf: Array[String]): Unit = {
    import inheritance.pack1.Customer

    import scala.collection.immutable.List
    val customerList: List[Customer] = List()

    // Demonstrate the use of Method Generics
    val listStack = new ListStack[String]
    listStack.push("C")
    listStack.push("B")
    listStack.push("A")
    val element: String = listStack.pop()
    println(element)
  }
}
