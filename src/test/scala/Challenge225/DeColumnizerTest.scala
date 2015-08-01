package Challenge225

import org.scalatest.{ShouldMatchers, FunSpec}
import org.scalatest._

class DeColumnizerTest extends FunSpec with ShouldMatchers{

  val input1 ="24\n" +
  "This is an example piece of text. This is an exam-\n" +
  "ple piece of text. This is an example piece of\n" +
  "text. This is an example\n" +
  "piece of text. This is a +-----------------------+\n" +
  "sample for a challenge.  |                       |\n" +
  "Lorum ipsum dolor sit a- |       top class       |\n" +
  "met and other words. The |        feature        |\n" +
  "proper word for a layout |                       |\n" +
  "like this would be type- +-----------------------+\n" +
  "setting, or so I would\n" +
  "imagine, but for now let's carry on calling it an\n" +
  "example piece of text. Hold up - the end of the\n" +
  "                 paragraph is approaching - notice\n" +
  "+--------------+ the double line break for a para-\n" +
  "|              | graph.\n" +
  "|              |\n" +
  "|   feature    | And so begins the start of the\n" +
  "|   bonanza    | second paragraph but as you can\n" +
  "|              | see it's only marginally better\n" +
  "|              | than the other one so you've not\n" +
  "+--------------+ really gained much - sorry. I am\n" +
  "                 certainly not a budding author\n" +
  "as you can see from this example input. Perhaps I\n" +
  "need to work on my writing skills."
  val output1 ="This is an example piece of text. This is an example piece of text. This is an example piece of text. This is an example piece of text. This is a sample for a challenge. Lorum ipsum dolor sit amet and other words. The proper word for a layout like this would be typesetting, or so I would imagine, but for now let's carry on calling it an example piece of text. Hold up - the end of the paragraph is approaching - notice the double line break for a paragraph.\nAnd so begins the start of the second paragraph but as you can see it's only marginally better than the other one so you've not really gained much - sorry. I am certainly not a budding author as you can see from this example input. Perhaps I need to work on my writing skills."
  it("Should process input1"){
    assert(DeColumnizer.processString(input1) == output1)
  }

  val input2 = "22\n" +
  "+-------------+ One hundred and fifty quadrillion,\n" +
  "|             | seventy-two trillion, six hundred\n" +
  "| 150 072 626 | and twenty-six billion, eight hun-\n" +
  "| 840 312 999 | dred and fourty million, three\n" +
  "|             | hundred and thirteen thousand sub-\n" +
  "+-------------+ tract one is a rather large prime\n" +
  "                number which equals one to five if\n" +
  "calculated modulo two to six respectively.\n" +
  "\n" +
  "However, one other rather more in- +-------------+\n" +
  "teresting number is two hundred    |             |\n" +
  "and twenty-one quadrillion, eight  | 221 806 434 |\n" +
  "hundred and six trillion, four     | 537 978 679 |\n" +
  "hundred and thirty-four billion,   |             |\n" +
  "five hundred and thirty-seven mil- +-------------+\n" +
  "million, nine hundred and seven-\n" +
  "                                ty-eight thousand,\n" +
  "+-----------------------------+ six hundred and\n" +
  "|                             | seventy nine,\n" +
  "| Subscribe for more Useless  | which isn't prime\n" +
  "|      Number Facts(tm)!      | but is the 83rd\n" +
  "+-----------------------------+ Lucas number."

  val output2= "One hundred and fifty quadrillion, seventy-two trillion, six hundred and twenty-six billion, eight hundred and fourty million, three hundred and thirteen thousand subtract one is a rather large prime number which equals one to five if calculated modulo two to six respectively.\nHowever, one other rather more interesting number is two hundred and twenty-one quadrillion, eight hundred and six trillion, four hundred and thirty-four billion, five hundred and thirty-seven milmillion, nine hundred and seventy-eight thousand, six hundred and seventy nine, which isn't prime but is the 83rd Lucas number."
  it("Should process input2"){
    assert(DeColumnizer.processString(input2) == output2)
  }

  val input3 = "16\n" +
    "+----------------+ Lorem ipsum dolor sit amet,\n" +
    "|                | consectetur adipiscing elit,\n" +
    "|  Aha, now you  | sed do eiusmod tempor incid-\n" +
    "|  are stumped!! | idunt ut labore et dolore\n" +
    "|                | magna aliqua. Ut enim ad mi-\n" +
    "|       +--------+ nim veniam, quis nostrud ex-\n" +
    "|  top  |          ercitation ullamco laboris\n" +
    "|  kek  | nisi ut aliquip ex.\n" +
    "|       |                       +-------------+\n" +
    "+-------+ Duis aute irure dolor |             |\n" +
    "in repre-henderit in voluptate  | Nothing to  |\n" +
    "velit esse cillum dolore eu fu- |  see here.  |\n" +
    "giat nulla pariatur. Excepteur  |             |\n" +
    "sint occaecat cupidatat non     +-------------+\n" +
    "proident, sunt in culpa qui of-\n" +
    "ficia deserunt mollit anim id est laborum."

  val output3 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex.\nDuis aute irure dolor in repre-henderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
  it("Should process input3"){
    assert(DeColumnizer.processString(input3) == output3)
  }


}
