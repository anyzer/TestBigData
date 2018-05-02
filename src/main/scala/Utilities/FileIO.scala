package Utilities

import java.io._
import java.util.zip._
import scala.io.Source

class FileIO {

  var maxTemp = 0;

  def readFileInFolder(path: String): List[File] = {
      var files: List[File] = List()
      val d = new File(path)

      if(d.exists() && d.isDirectory()){
          files = d.listFiles.filter(_.isFile()).filter(_.getName().contains(".gz")).toList
      }else {
          List[File]()
      }
      files
  }

  def readMaxTempFromGzFile(file: File): Int = {
    var maxTemp = 0;

    var input = new GZIPInputStream(new FileInputStream(file))

    for(line <- Source.fromInputStream(input).getLines()) {
//        println(line.substring(88, 92) + " =>  " + line)

        var t = line.substring(88, 92).toInt;
//        println("Temperature: " + t)

        if(t > maxTemp || t < 1000) {
          maxTemp = t;
//          println("Max Temp: " + maxTemp)
        }
    }

    return maxTemp
  }

}
