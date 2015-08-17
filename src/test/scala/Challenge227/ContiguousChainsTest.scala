package Challenge227

import org.scalatest.{ShouldMatchers, FunSpec}

class ContiguousChainsTest extends FunSpec with ShouldMatchers{

  val inputOne = "xxxxxxxx\nx      x"
  val inputTwo = "xxxx xxxx\n    x    \n   xx    "
  val inputThree = "xxxx xxxx\n   xxx   \nx   x   x\nxxxxxxxxx"
  val inputFour = "xx x xx x  \nx  x xx x  \nxx   xx  x \nxxxxxxxxx x\n         xx\nxxxxxxxxxxx\n x x x x x \n  x x x x  "

  it("Should find one contiguous chain for input one"){
    val matrix = ContiguousChains.textToMatrix(inputOne)
    assert(ContiguousChains.countSubgraphs(matrix) == 1)
  }

  it("Should find three contiguous chains for input two"){
    val matrix = ContiguousChains.textToMatrix(inputTwo)
    assert(ContiguousChains.countSubgraphs(matrix) == 3)

  }

  it("Should find some contiguous chains for input three"){
    val matrix = ContiguousChains.textToMatrix(inputThree)
    assert(ContiguousChains.countSubgraphs(matrix) == 1)

  }

  it("Should find three contiguous chains for input four"){
    val matrix = ContiguousChains.textToMatrix(inputFour)
    assert(ContiguousChains.countSubgraphs(matrix) == 9)

  }


}
