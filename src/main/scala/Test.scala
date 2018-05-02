import java.io.File

import Utilities.FileIO

object Test extends App {
  var maxTemp = 0;
  val fileIO = new FileIO();
  var files: List[File] = fileIO.readFileInFolder(".//weather//")
  println("There are " + files.size + " files:\n")

  val t0 = System.currentTimeMillis()
  for(file <- files) {
    var tmp = fileIO.readMaxTempFromGzFile(file)
    println("File: " + file.getName + ": " + tmp)
  }
  val t1 = System.currentTimeMillis()

  println("\nElapsed time: " + (t1 - t0) / 1000 + " s")

//  println("\n")
//  var f = new File(".//weather//1901.gz")
//  fileIO.readMaxTempFromGzFile(f)


}
