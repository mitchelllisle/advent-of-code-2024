package io.github.mitchelllisle.DayFour

import io.github.mitchelllisle.Solution

class DayFourPartTwo(path: String) extends Solution[Int] {

  private def checkMAS(grid: Array[Array[Char]], row: Int, col: Int,
                       deltaRow: Int, deltaCol: Int): Boolean = {
    // Check if we can form MAS or SAM in the given direction from the center A
    val prevRow = row - deltaRow
    val prevCol = col - deltaCol
    val nextRow = row + deltaRow
    val nextCol = col + deltaCol

    if (prevRow < 0 || prevRow >= grid.length ||
      prevCol < 0 || prevCol >= grid(0).length ||
      nextRow < 0 || nextRow >= grid.length ||
      nextCol < 0 || nextCol >= grid(0).length) {
      return false
    }

    val prev = grid(prevRow)(prevCol)
    val next = grid(nextRow)(nextCol)

    // Check for MAS (M before A, S after A) or SAM (S before A, M after A)
    (prev == 'M' && next == 'S') || (prev == 'S' && next == 'M')
  }

  private def checkXPattern(grid: Array[Array[Char]], row: Int, col: Int): Boolean = {
    // A must be at the center
    if (grid(row)(col) != 'A') return false

    // Check both diagonals: top-left to bottom-right AND top-right to bottom-left
    checkMAS(grid, row, col, 1, 1) && checkMAS(grid, row, col, 1, -1)
  }

  override def solve(): Int = {
    val grid = read(path).map(_.toCharArray)
    var count = 0

    // Iterate through each position in the grid
    for {
      row <- grid.indices
      col <- grid(row).indices
      if checkXPattern(grid, row, col)
    } count += 1

    count
  }
}
