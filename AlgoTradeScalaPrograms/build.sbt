name := "AlgoTradeScalaPrograms"

version := "0.1"

scalaVersion := "2.13.11"

mainClass in Compile := Some("tryScallop.Main3")
libraryDependencies += "javax.inject" % "javax.inject" % "1"
// https://mvnrepository.com/artifact/com.google.inject/guice
libraryDependencies += "com.google.inject" % "guice" % "7.0.0"
// https://mvnrepository.com/artifact/org.rogach/scallop
libraryDependencies += "org.rogach" %% "scallop" % "5.0.1"
