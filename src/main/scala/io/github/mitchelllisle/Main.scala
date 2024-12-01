package io.github.mitchelllisle

import io.github.mitchelllisle.DayOne.{DayOnePartOne, DayOnePartTwo}


object Main {
  def main(args: Array[String]): Unit = {
    val solutions = Seq(
      new DayOnePartOne[Int]("src/main/resources/DayOne.txt"),
      new DayOnePartTwo[Int]("src/main/resources/DayOne.txt"),
    )
    solutions.foreach(_.printSolution())
  }
}
