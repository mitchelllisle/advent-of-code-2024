package io.github.mitchelllisle.DaySeven

import io.github.mitchelllisle.Solution

class DaySevenPartOne(path: String) extends Solution[Long] {

  private def parseLine(line: String): (Long, List[Long]) = {
    val parts = line.split(": ")
    val target = parts(0).toLong
    val nums = parts(1).split(" ").map(_.toLong).toList
    (target, nums)
  }

  private def canMakeTarget(target: Long, nums: List[Long]): Boolean = {
    def go(acc: Long, remaining: List[Long]): Boolean = {
      if (remaining.isEmpty) acc == target
      else if (acc > target) false  // prune: values only grow
      else {
        val next :: rest = remaining
        go(acc + next, rest) || go(acc * next, rest)
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
