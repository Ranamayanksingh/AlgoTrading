package tryScallop

import org.rogach.scallop.ScallopConf

class MyConfig(arguments:Seq[String]) extends ScallopConf(arguments) {
  val input = opt[String](name="input",required = true,descr = "Input file path")
  val output = opt[String](name="output",required = true,descr = "Output File path")
  val verbose = toggle("verbose",noshort=true,default = Some(false),descrYes = "Enable verbose mode")
}
