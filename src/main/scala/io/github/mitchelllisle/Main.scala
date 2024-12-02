package io.github.mitchelllisle

import io.github.mitchelllisle.DayOne.{DayOnePartOne, DayOnePartTwo}
import io.github.mitchelllisle.DayTwo.DayTwoPartOne


object Main {
  def main(args: Array[String]): Unit = {
    val solutions = Seq(
      new DayOnePartOne[Int]("src/main/resources/DayOne.txt"),
      new DayOnePartTwo[Int]("src/main/resources/DayOne.txt"),
      new DayTwoPartOne[Int]("src/main/resources/DayTwo.txt"),
    )
    solutions.foreach(_.printSolution())
  }
}
