package io.github.mitchelllisle

import io.github.mitchelllisle.DayOne.{DayOnePartOne, DayOnePartTwo}
import io.github.mitchelllisle.DayTwo.{DayTwoPartOne, DayTwoPartTwo}


object Main {
  def main(args: Array[String]): Unit = {
    val solutions = Seq(
      new DayOnePartOne("src/main/resources/DayOne.txt"),
      new DayOnePartTwo("src/main/resources/DayOne.txt"),
      new DayTwoPartOne("src/main/resources/DayTwo.txt"),
      new DayTwoPartTwo("src/main/resources/DayTwo.txt"),
    )
    solutions.foreach(_.printSolution())
  }
}
