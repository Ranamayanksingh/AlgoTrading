

import java.nio.file.{Files, Path, Paths}
import java.util.Comparator
import scala.collection.mutable.ListBuffer
import scala.io.Source

object utils {
//  Date,Open,High,Low,Close,Adj Close,Volume
  case class OHLCV(tickerName: String,date:String,Open:Double,High:Double,Low:Double,Close:Double,Adj_Close:Double,Volume:Long)
  case class ChangePer(Change:Double, PercentChange:Double)

  def removeFileOrFolder(path: Path): Unit = {
    try{
      if (Files.isDirectory(path)) {
        Files.walk(path)
          .sorted(Comparator.reverseOrder)
          .forEach(x => Files.delete(x))
      } else {
        Files.delete(path)
      }
    } catch {
      case ex:Exception =>
        println(s"$path does not exists !!,error -> ${ex.getMessage}")
    }
  }



  def readFromDayFile(tickerName:String,filePath: String): Either[OHLCV,String] = {
    val lines: Seq[String] = Source.fromFile(filePath).getLines().toList
    try{
      lines.size match {
        case 3 =>
          val line = lines(1)
          val Array(date, open, high, low, close, adj_close, volume) = line.split(",")
          Left(OHLCV(tickerName, date, open.toDouble.toInt.toDouble, high.toDouble.toInt.toDouble, low.toDouble.toInt.toDouble, close.toDouble.toInt.toDouble, adj_close.toDouble.toInt.toDouble, volume.toDouble.toLong))
        case 2 =>
          val line = lines(1)
          val Array(date, open, high, low, close, adj_close, volume) = line.split(",")
          Left(OHLCV(tickerName, date, open.toDouble.toInt.toDouble, high.toDouble.toInt.toDouble, low.toDouble.toInt.toDouble, close.toDouble.toInt.toDouble, adj_close.toDouble.toInt.toDouble, volume.toDouble.toLong))
        case 1 =>
          println(s"data is not present for ticker:${tickerName}")
          Right(s"data is not present for ticker:${tickerName}")
        case _ =>
          println(s"for ticker:${tickerName} either 0 or more than 2 lines have been downloaded ")
          Right(s"data is not present for ticker:${tickerName}")
      }
    } catch {
      case ex:Exception =>
        println(s"for ticker : $tickerName , got exception:${ex.getMessage}")
        Right(s"for ticker : $tickerName , got exception:${ex.getMessage}")
    }
  }


  def listFiles(folderPath: String): List[String] = {
    val folder = Paths.get(folderPath)
    if (Files.isDirectory(folder)) {
      Files.list(folder).map(x => x.toString).toArray.toList.asInstanceOf[List[String]]
    } else {
      Nil
    }
  }

  def calculatePercentChange(listOfOHLCV:List[OHLCV]):List[(OHLCV,ChangePer)] ={
    listOfOHLCV.map(x =>{
     try{
       val open = x.Open
       val close = x.Close
       val change = (close-open).toDouble
       val percentChange = (change*100/open).toDouble
       (x,ChangePer(change,percentChange))
     } catch {
       case ex:Exception =>
         println(s"for ticker:${x} error while calculating percent change: ${ex.getMessage}")
         (x,ChangePer(0.toDouble,0.toDouble))
     }
    })
  }

  def getOHLCVDataOfDayFile(basePath:String):List[OHLCV] = {
    val files: Seq[String] = listFiles(basePath)
    val nameFiles = files.map(x => {
      val name = x.replaceAll(basePath,"").replaceAll(".NS.csv","")
      (name,x)
    })

    var listOfData = ListBuffer[OHLCV]()
    var listOfIncorrectData = ListBuffer[String]()
    nameFiles.foreach(x => {
      readFromDayFile(x._1,x._2) match {
        case Left(value) => listOfData.append(value)
        case Right(value) =>
          listOfIncorrectData.append(x._1)
          println(value)
      }
    })
    listOfData.toList
  }

}
