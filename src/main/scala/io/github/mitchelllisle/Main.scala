package io.github.mitchelllisle

object Main {
  def main(args: Array[String]): Unit = {
    Seq(new DayOne("src/main/resources/DayOne.txt")).foreach(_.printSolution[Int]())
  }
}
