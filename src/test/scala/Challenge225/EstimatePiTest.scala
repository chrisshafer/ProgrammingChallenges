package Challenge225

import java.io.File

import org.scalatest.{ShouldMatchers, FunSpec}
import org.scalatest._



class EstimatePiTest extends FunSpec with ShouldMatchers{

  val files : Seq[File] = Seq(new File(getClass.getResource("/EstimatePi1.png").toURI),
                  new File(getClass.getResource("/EstimatePi2.png").toURI))

  it("Should load images"){
    files.foreach { file =>
      println(EstimatePiFromImage.loadImage(file))
      assert(EstimatePiFromImage.loadImage(file).getWidth > 0 )
    }
  }
  it("Should determine pi to a reasonable accuracy given a suficient size"){
    files.foreach { file =>
      val result = EstimatePiFromImage.estimatePiFromImageFile(file)
      println(file.getName + " : " + result)
      assert( result < 3.15 )
      assert( result > 3.13 )
    }
  }

}
