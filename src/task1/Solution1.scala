package task1

import java.io.{File, FileInputStream, PrintWriter}
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import scala.io.Source

object Solution1 extends App {

  val workingDir = "resources/task1"
  val inputFile = s"$workingDir/input.in"
  val outputFile = s"$workingDir/output.out"

  //reading line by line
  val lines: Iterator[String] = Source.fromFile(inputFile).getLines()
  val writer = new PrintWriter(new File(outputFile))
  lines.foreach {
    line =>
      val sum = line.split("\\s+").map(_.trim.toInt).sum
      writer.write(sum + "\n")
  }
  writer.close()

  // scanning for integers
  val sc = new java.util.Scanner(new FileInputStream(inputFile))
  while(sc.hasNext()) {
    print(sc.nextInt())
  }


  def writeToFile(path: String, txt: String): Unit = {
    Files.write(Paths.get(path), txt.getBytes(StandardCharsets.UTF_8))
  }

  def readFile(path: String): String =
    scala.io.Source.fromFile(path, "UTF-8").getLines.mkString
}
