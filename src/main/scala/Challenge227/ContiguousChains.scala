package Challenge227

import scala.annotation.tailrec

object ContiguousChains extends App{

  def textToMatrix(input: String): Array[Array[Int]] = {
    input.split("\n").map(_.toCharArray.map {
      case 'x' => 1
      case _ => 0
    })
  }

  def countSubgraphs(graph: Array[Array[Int]]): Int ={
    var evilgraph = graph
    var iterations = 0
    while(unvisitedRoot(evilgraph).isDefined){
      evilgraph = flood(unvisitedRoot(evilgraph).get,evilgraph)
      iterations += 1
    }
    iterations
  }

  def unvisitedRoot(graph: Array[Array[Int]]): Option[(Int,Int)]={
    val nodes = for{
      x <- 0 to graph.length - 1
      y <- 0 to graph(x).length -1
      if graph(x)(y) == 1
    }yield Some((x, y))

    nodes.filter(_.isDefined).toSeq match {
      case x if x.nonEmpty => x.last
      case _ => None
    }
  }

  def flood(node : (Int,Int),graph: Array[Array[Int]]): Array[Array[Int]] ={
    node match {
      case outOfBounds if node._1 < 0 || node._2 < 0 => graph
      case outOfRange if node._1 >= graph.length => graph
      case outOfRange if node._2 >= graph(node._1).length => graph
      case visited if graph(node._1)(node._2) == 2 => graph
      case blocked if graph(node._1)(node._2) == 0 => graph
      case _ =>
        val replacement: Array[Int] = graph(node._1).patch(node._2,Seq(2),1)

        flood((node._1,node._2 +1 ),
          flood((node._1,node._2 -1 ),
            flood((node._1 +1 ,node._2  ),
              flood((node._1 -1,node._2 ),
                graph.patch(node._1,Seq(replacement),1)))))

    }
  }

}
