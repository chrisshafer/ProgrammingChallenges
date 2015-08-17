package Challenge227

import org.scalatest._

class SquareSpiralsTest extends FunSpec with ShouldMatchers{

  it("Should build a spiral"){
    val matrix = SquareSpirals.genSpiral(11)
    matrix.map( x => println( x.mkString(",")))
  }

  val inputOne = "3\n8"
  it("Should find cords for 8 at 2,3"){
    assert(SquareSpirals.readInput(inputOne).right.get == (2,3))
  }

  val inputTwo = "7\n1 1"
  it("Should find 37 at 1,1"){
    val result = SquareSpirals.readInput(inputTwo)
    assert(result.isLeft)
    assert(result.left.get == 37)
  }

  val inputThree = "11\n50"
  it("Should find 50 at 47"){
    val result = SquareSpirals.readInput(inputThree)
    assert(result.isRight)
    assert(result.right.get == (10,9))
  }

  val inputFour = "9\n6 8"
  it("Should find 47 at 6,8"){
    val result = SquareSpirals.readInput(inputFour)
    assert(result.isLeft)
    assert(result.left.get == 47)
  }


}
