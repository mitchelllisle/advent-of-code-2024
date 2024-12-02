package io.github.mitchelllisle.DayTwo

import io.github.mitchelllisle.Solution

class DayTwoPartOne[T](path: String) extends Solution[T] {
  private def withinTolerance(a: Int, b: Double): Boolean = {
    b match {
      case Double.NegativeInfinity => true
      case Double.PositiveInfinity => true
      case _ =>
        val diff = Math.abs(a - b)
        diff >= 1 && diff <= 3
    }
  }

  private def rowLogic(arr: Array[Int], increasing: Boolean): Boolean = {
    var switch = true
    var prev: Double = 0
    val calc: (Int, Int) => Boolean = if (increasing) {
      prev = Double.NegativeInfinity
      (x: Int, y: Int) => x > y
    } else {
      prev = Double.PositiveInfinity
      (x: Int, y: Int) => x < y
    }

    arr.foreach { num =>
      if (calc(num, prev.toInt)) {
        if (!withinTolerance(num, prev)) {
          return false
        }
        switch = true
        prev = num
      } else {
        return false
      }
    }
    switch
  }

  override def solve(): T = {
    val input = read(path)
    val parsed = DayTwoUtils.parse(input)

    val allIncreased = parsed.map(rowLogic(_, increasing = true))
    val allDecreased = parsed.map(rowLogic(_, increasing = false))
    allIncreased.zip(allDecreased).count(pair => pair._1 || pair._2).asInstanceOf[T]
  }
}
