import utils._

import java.nio.file.Paths
import scala.collection.mutable.ListBuffer
object Main extends App {
//  removeFileOrFolder(Paths.get("/Users/mayanksinghrana/AlgoTrading/Data/SBIN_day.csv"))

  /** calculate percent change of each day */
//  val basePath7Aug = "/Users/mayanksinghrana/AlgoTrading/Data/1d/2023-08-07/"
//  val basePath8Aug = "/Users/mayanksinghrana/AlgoTrading/Data/1d/2023-08-08/"
//  val listofdata7Aug = getOHLCVDataOfDayFile(basePath7Aug)
//  val listOfdata8Aug = getOHLCVDataOfDayFile(basePath8Aug)
//
//  val percentChangeList7Aug = calculatePercentChange(listofdata7Aug).filter(x => x._2.PercentChange>0)
//  val percentChangeList8Aug = calculatePercentChange(listOfdata8Aug).filter(x => x._2.PercentChange>0)
//
//  val nameOf7Aug = percentChangeList7Aug.map(x => x._1.tickerName).toSet
//
//  val nameOf8Aug = percentChangeList8Aug.filter(x => nameOf7Aug.contains(x._1.tickerName))
//
//  nameOf8Aug.sortBy(x => x._2.PercentChange).foreach(println)


  /** Calculate percent change of each day !!! */
  val pathOf29Aug = "/Users/mayanksinghrana/AlgoTrading/Data/1d/2024-02-02/"
  val list1 = caculatePercentChangeOfDay(pathOf29Aug).filter(x => x._2.PercentChange > 0 && x._2.Change > 10).sortBy(x => x._2.PercentChange)
//    .filter(x => x._1.Close < 1000)
  list1.foreach(println)

//  val pathOf28Aug = "/Users/mayanksinghrana/AlgoTrading/Data/1d/2023-09-05/"
//  val list2 = caculatePercentChangeOfDay(pathOf28Aug)
//
//  val bothDaysIncrease = list2.map(x => x._1.tickerName).intersect(list1.map(x => x._1.tickerName))
//

//  bothDaysIncrease.foreach(println)



  def caculatePercentChangeOfDay(filePath:String) = {
    val listOfData = getOHLCVDataOfDayFile(filePath)
    val percentChangeList = calculatePercentChange(listOfData)
    percentChangeList.filter(x =>  x._2.Change > 0 ).sortBy(x => x._2.PercentChange )
  }


}
