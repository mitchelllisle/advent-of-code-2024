package io.github.mitchelllisle.DaySeven

import io.github.mitchelllisle.Solution

class DaySevenPartTwo(path: String) extends Solution[Long] {

  private def parseLine(line: String): (Long, List[Long]) = {
    val parts = line.split(": ")
    val target = parts(0).toLong
    val nums = parts(1).split(" ").map(_.toLong).toList
    (target, nums)
  }

  private def concat(a: Long, b: Long): Long = {
    var shift = b
    var multiplier = 10L
    while (shift >= multiplier) multiplier *= 10L
    a * multiplier + b
  }

  private def canMakeTarget(target: Long, nums: List[Long]): Boolean = {
    def go(acc: Long, remaining: List[Long]): Boolean = {
      if (remaining.isEmpty) acc == target
      else if (acc > target) false  // prune
      else {
        val next :: rest = remaining
        go(acc + next, rest) || go(acc * next, rest) || go(concat(acc, next), rest)
      }
    }
    nums match {
      case Nil => false
      case head :: tail => go(head, tail)
    }
  }

  override def solve(): Long = {
    read(path)
      .map(parseLine)
      .filter { case (target, nums) => canMakeTarget(target, nums) }
      .map(_._1)
      .sum
  }
}
