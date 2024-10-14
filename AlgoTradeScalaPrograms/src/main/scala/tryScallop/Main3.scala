package tryScallop

object Main3 {
  def main(args:Array[String]) = {
    val config = new MyConfig(args.toSeq)
    try{
      config.verify()
    } catch {
      case e:Exception =>
        print(s"Error : ${e.getMessage}")
    }
    val inputFilePath = config.input()
    val outputFilePath = config.output()
    val isVerbose = config.verbose()

    println(s"intput file name is ${inputFilePath}")
  }
}
