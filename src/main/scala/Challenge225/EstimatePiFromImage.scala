package Challenge225

import java.io.File

object EstimatePiFromImage extends App{

  def loadImage(f: File): java.awt.image.Raster = javax.imageio.ImageIO.read(f).getData
  def piFromOldSchool(area: Double, radius: Double): Double = area / Math.pow(radius,2)
  def estimatePi(image: java.awt.image.Raster): Double = {

    val blackOrWhitePixelXPos:Seq[(Int,Boolean)] = for {
      x <- image.getMinX to (image.getWidth - 1)
      y <- image.getMinY to (image.getHeight - 1)
    } yield {
      (x,image.getPixel(x,y,new Array[Float](3)).forall( _ == 0.0))
    }
    val blackPixels = blackOrWhitePixelXPos.filter(_._2)
    val minX = blackPixels.minBy(_._1)._1
    val maxX = blackPixels.maxBy(_._1)._1
    piFromOldSchool( area = blackPixels.length, radius = (maxX-minX)/2.0)
  }
  def estimatePiFromImageFile(f:File) = estimatePi(loadImage(f))

}
