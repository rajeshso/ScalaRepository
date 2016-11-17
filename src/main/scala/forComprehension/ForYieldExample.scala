package forComprehension

/**
  * Created by E797240 on 17/11/2016.
  */
class ForYieldExample {

}

object ForYieldExample {
  def main(sdf : Array[String]): Unit = {
    //for (i <- 1 to 5) yield {println(i)}
    var seqInt :Seq[Int] = for(i <- 0 to 5) yield i
    //println(seqInt.size)

    var seqDoubleInt : Seq[Int] = for(i <- 0 to 5) yield {i*2}
    //println(seqDoubleInt)

    for {
      i <- 0 to 5
      j <- 0 to 5
    } yield {
      (i, j)
    }
    // The above for loop is equivalent to the following flatMap function
    (0 to 5).flatMap {
      i => (0 to 5).map {
        j => {println(i + " " + j); (i,j)}
      }
    }

    val a : Range.Inclusive = 0 to 5
    val b = 0 to 5
    val x : IndexedSeq[IndexedSeq[(Int, Int)]]= a.map(i=> b.map(j=> (i,j)))
    val y : IndexedSeq[(Int,Int)] = a.flatMap(i=> b.map(j=> (i,j))) //Note how the flat map has flattened the tuples
  }
}