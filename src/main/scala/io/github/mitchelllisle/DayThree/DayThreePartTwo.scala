package io.github.mitchelllisle.DayThree

import io.github.mitchelllisle.Solution

import scala.util.matching.Regex

/**
 * --- Day 3: Mull It Over ---
 * "Our computers are having issues, so I have no idea if we have any Chief Historians in stock! You're welcome to check the warehouse, though," says the mildly flustered shopkeeper at the North Pole Toboggan Rental Shop. The Historians head out to take a look.
 *
 * The shopkeeper turns to you. "Any chance you can see why our computers are having issues again?"
 *
 * The computer appears to be trying to run a program, but its memory (your puzzle input) is corrupted. All of the instructions have been jumbled up!
 *
 * It seems like the goal of the program is just to multiply some numbers. It does that with instructions like mul(X,Y), where X and Y are each 1-3 digit numbers. For instance, mul(44,46) multiplies 44 by 46 to get a result of 2024. Similarly, mul(123,4) would multiply 123 by 4.
 *
 * However, because the program's memory has been corrupted, there are also many invalid characters that should be ignored, even if they look like part of a mul instruction. Sequences like mul(4*, mul(6,9!, ?(12,34), or mul ( 2 , 4 ) do nothing.
 *
 * For example, consider the following section of corrupted memory:
 *
 * `xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))`
 *
 * Only the four highlighted sections are real mul instructions. Adding up the result of each instruction produces 161 (2*4 + 5*5 + 11*8 + 8*5).
 *
 * Scan the corrupted memory for uncorrupted mul instructions. What do you get if you add up all of the results of the multiplications?
* */
class DayThreePartTwo(path: String) extends Solution[Int] {
  private def processInstruction(mul: String): Int = {
    val expr = "\\d+".r
    val numbers = expr.findAllIn(mul).map(_.toInt).toList
    val product = numbers.head * numbers(1)
    product
  }

  private def findMatchIndices(text: String, pattern: Regex): List[(Int, String)] = {
    pattern.findAllMatchIn(text)
      .map(m => (m.start, m.group(0)))
      .toList
  }

  override def solve(): Int = {
    val input = read(path).mkString
    val instructionsWithPositions = findMatchIndices(input, "(mul\\(\\d+,\\d+\\))".r)

    var validInstructions: List[Int] = List.empty

    var doInstruction = true

    for (row <- instructionsWithPositions.zipWithIndex) {
      val (position, instruction, index) = (row._1._1, row._1._2, row._2)

      if (doInstruction) {
        val product = processInstruction(instruction)
        validInstructions = validInstructions :+ product
      }

      if (index < instructionsWithPositions.length - 1) {
      val nextRow = instructionsWithPositions(index + 1)
      val window = input.slice(position, nextRow._1)

      if (window.contains("don't")) {
        doInstruction = false
      } else if (window.contains("do")) {
        doInstruction = true
      }
      }
    }
    validInstructions.sum
  }
}
