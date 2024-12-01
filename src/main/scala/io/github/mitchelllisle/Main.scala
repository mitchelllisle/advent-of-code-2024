package io.github.mitchelllisle

object Main {
  def main(args: Array[String]): Unit = {
    val solutions = Seq(new DayOne[Int]("src/main/resources/DayOne.txt"))
    solutions.foreach(_.printSolution())
  }
}
