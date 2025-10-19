package io.github.mitchelllisle.DayFour

import io.github.mitchelllisle.Solution

class DayFourPartOne(path: String) extends Solution[Int] {
  private val sequence = Seq('X', 'M', 'A', 'S')

  private val directions = Seq(
    (-1, 0),  // up
    (1, 0),   // down
    (0, -1),  // left
    (0, 1),   // right
    (-1, -1), // up-left
    (-1, 1),  // up-right
    (1, -1),  // down-left
    (1, 1)    // down-right
  )

  private def checkDirection(grid: Array[Array[Char]], row: Int, col: Int,
                             deltaRow: Int, deltaCol: Int): Boolean = {
    sequence.indices.forall { i =>
      val newRow = row + (i * deltaRow)
      val newCol = col + (i * deltaCol)

      newRow >= 0 && newRow < grid.length &&
        newCol >= 0 && newCol < grid(0).length &&
        grid(newRow)(newCol) == sequence(i)
    }
  }

  override def solve(): Int = {
    val grid = read(path).map(_.toCharArray)
    var count = 0

    for {
      row <- grid.indices
      col <- grid(row).indices
      if grid(row)(col) == 'X'
    } {
      count += directions.count { case (deltaRow, deltaCol) =>
        checkDirection(grid, row, col, deltaRow, deltaCol)
      }
    }
    count
  }
}