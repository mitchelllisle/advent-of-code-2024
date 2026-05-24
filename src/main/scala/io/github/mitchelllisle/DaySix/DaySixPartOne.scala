package io.github.mitchelllisle.DaySix

import io.github.mitchelllisle.Solution

class DaySixPartOne(path: String) extends Solution[Int] {

  // Directions in order: up, right, down, left
  private val directions = Array((-1, 0), (0, 1), (1, 0), (0, -1))

  private def parseGrid(lines: Array[String]): (Array[Array[Char]], (Int, Int), Int) = {
    val grid = lines.map(_.toCharArray)
    var startRow = 0
    var startCol = 0
    var startDir = 0 // 0 = up
    for (r <- grid.indices; c <- grid(r).indices) {
      grid(r)(c) match {
        case '^' => startRow = r; startCol = c; startDir = 0; grid(r)(c) = '.'
        case '>' => startRow = r; startCol = c; startDir = 1; grid(r)(c) = '.'
        case 'v' => startRow = r; startCol = c; startDir = 2; grid(r)(c) = '.'
        case '<' => startRow = r; startCol = c; startDir = 3; grid(r)(c) = '.'
        case _ =>
      }
    }
    (grid, (startRow, startCol), startDir)
  }

  def countVisited(lines: Array[String]): Int = {
    val (grid, (startRow, startCol), startDir) = parseGrid(lines)
    val rows = grid.length
    val cols = grid(0).length

    val visited = scala.collection.mutable.Set[(Int, Int)]()
    var row = startRow
    var col = startCol
    var dir = startDir

    var running = true
    while (running) {
      visited.add((row, col))
      val (dr, dc) = directions(dir)
      val nr = row + dr
      val nc = col + dc
      if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
        running = false
      } else if (grid(nr)(nc) == '#') {
        dir = (dir + 1) % 4
      } else {
        row = nr
        col = nc
      }
    }
    visited.size
  }

  override def solve(): Int = {
    val lines = read(path)
    countVisited(lines)
  }
}
