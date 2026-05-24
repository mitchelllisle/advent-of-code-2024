package io.github.mitchelllisle

import io.github.mitchelllisle.DayFour.{DayFourPartOne, DayFourPartTwo}
import io.github.mitchelllisle.DayOne.{DayOnePartOne, DayOnePartTwo}
import io.github.mitchelllisle.DayTwo.{DayTwoPartOne, DayTwoPartTwo}
import io.github.mitchelllisle.DayThree.{DayThreePartOne, DayThreePartTwo}
import io.github.mitchelllisle.DayFive.{DayFivePartOne, DayFivePartTwo}
import io.github.mitchelllisle.DaySix.{DaySixPartOne, DaySixPartTwo}
import io.github.mitchelllisle.DaySeven.{DaySevenPartOne, DaySevenPartTwo}


object Main {
  def main(args: Array[String]): Unit = {
    val solutions = Seq(
      new DayOnePartOne("src/main/resources/DayOne.txt"),
      new DayOnePartTwo("src/main/resources/DayOne.txt"),
      new DayTwoPartOne("src/main/resources/DayTwo.txt"),
      new DayTwoPartTwo("src/main/resources/DayTwo.txt"),
      new DayThreePartOne("src/main/resources/DayThree.txt"),
      new DayThreePartTwo("src/main/resources/DayThree.txt"),
      new DayFourPartOne("src/main/resources/DayFour.txt"),
      new DayFourPartTwo("src/main/resources/DayFour.txt"),
      new DayFivePartOne("src/main/resources/DayFive.txt"),
      new DayFivePartTwo("src/main/resources/DayFive.txt"),
      new DaySixPartOne("src/main/resources/DaySix.txt"),
      new DaySixPartTwo("src/main/resources/DaySix.txt"),
      new DaySevenPartOne("src/main/resources/DaySeven.txt"),
      new DaySevenPartTwo("src/main/resources/DaySeven.txt")
    )
    solutions.foreach(_.printSolution())
  }
}
