package pack3

import scala.collection.mutable.Iterable
import scala.math.Ordered

trait Sortable[A <: Ordered[A]] extends Iterable[A] {
  def sort : Seq[A] = {
    this.toList.sorted
  }
}