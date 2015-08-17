package Challenge227

object SquareSpirals {

  // Horrible code, but this is a race
  // 44 min for tests and solution
  def genSpiral(size: Int): Array[Array[Int]] ={
    var direction = 0
    var length = 1
    var tock = false
    var last = 1
    var x = Math.round((size-1)/2)
    var y = Math.round((size-1)/2)
    val spiral = Array.fill(size)(0).map(x => Array.fill(size)(0))
    spiral(x)(y)=last
    last += 1

    while(last <= size * size){
      var used = length

      while(used > 0 && !outOfBounds(size,(x+1,y)) && last <= size * size){
        x += 1
        spiral(y)(x) = last
        used -= 1
        last += 1
      }

      used = length
      while(used > 0 && !outOfBounds(size,(x,y-1)) && last <= size * size){
        y -= 1
        spiral(y)(x) = last
        last += 1
        used -= 1

      }

      length += 1
      used = length

      while(used > 0 && !outOfBounds(size,(x-1,y)) && last <= size * size){
        x -= 1
        spiral(y)(x) = last
        last += 1
        used -= 1
      }

      used = length
      while(used > 0 && !outOfBounds(size,(x,y+1)) && last <= size * size){
        y += 1
        spiral(y)(x) = last
        last += 1
        used -= 1
      }

      length += 1
    }
    spiral
  }
  def outOfBounds(size: Int, xy: (Int,Int)): Boolean ={
     xy._1 >= size || xy._2 >= size || xy._1 < 0 || xy._2 < 0
  }

  // yea this is O(n) wutcha going to do about it ?
  def findPosOfNumber(matrix: Array[Array[Int]], number: Int ): (Int,Int) ={
    val pos = for{
      x <- 0 to matrix.size -1
      y <- 0 to matrix.size -1
      if matrix(y)(x) == number
    } yield (x+1,y+1)

    pos.last
  }
  def readInput(input: String): Either[Int,(Int,Int)] ={
    val inputs = input.split("\n")
    val matrix = genSpiral(inputs(0).toInt)
    cordsOrNumber(inputs(1)) match {
      case Right(cords) =>
        Left(matrix(cords._2-1)(cords._1-1))
      case Left(number) =>
        Right(findPosOfNumber(matrix,number))
      case _ => Left(-1)
    }

  }
  def cordsOrNumber(input: String): Either[Int,(Int,Int)] ={
    val cordsOrNumber = input.split(" ")
    if( cordsOrNumber.length == 2){
      Right((cordsOrNumber(0).toInt,cordsOrNumber(1).toInt))
    } else Left(cordsOrNumber(0).toInt)

  }

}
