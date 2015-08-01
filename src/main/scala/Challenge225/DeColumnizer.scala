package Challenge225


object DeColumnizer extends App{

  def processString(input: String): String ={
    val contents = """(\|.*\|)|(\+-*\+( ))|(\|.*\+)""".r.findAllIn(input)

    input.replaceFirst("""(.*\n)""","")
      .replaceAll("""(\|.*\|)|(\+-*\+( ))|(\|.*\+)""","")
      .replaceAll("""(\+-*\+(\n))""","\n")
      .replaceAll("""(- *\n *)""","")
      .replaceAll("""(-\n *)""","")
      .replaceAll("""( - )""","\t")
      .replaceAll("""((a-z)|- *)""","-")
      .replaceAll("\t"," - ")
      .replaceAll("(\n\n *)|(\n *\n)","\t")
      .replaceAll("""(\n *)"""," ")
      .replaceAll("\t","\n")
      .replaceAll("(  *)"," ")

  }
}
