package io.github.mitchelllisle.DaySix

import io.github.mitchelllisle.Solution

class DaySixPartTwo(path: String) extends Solution[Int] {

  private val directions = Array((-1, 0), (0, 1), (1, 0), (0, -1))

  private def parseGrid(lines: Array[String]): (Array[Array[Char]], (Int, Int), Int) = {
    val grid = lines.map(_.toCharArray)
    var startRow = 0
    var startCol = 0
    var startDir = 0
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

  private def getVisitedPositions(
      grid: Array[Array[Char]],
      startRow: Int,
      startCol: Int,
      startDir: Int
  ): Set[(Int, Int)] = {
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
    visited.toSet
  }

  private def causesLoop(
      grid: Array[Array[Char]],
      startRow: Int,
      startCol: Int,
      startDir: Int,
      obstRow: Int,
      obstCol: Int
  ): Boolean = {
    val rows = grid.length
    val cols = grid(0).length
    val visited = scala.collection.mutable.Set[(Int, Int, Int)]()
    var row = startRow
    var col = startCol
    var dir = startDir
    var running = true
    var loop = false
    while (running) {
      val state = (row, col, dir)
      if (visited.contains(state)) {
        loop = true
        running = false
      } else {
        visited.add(state)
        val (dr, dc) = directions(dir)
        val nr = row + dr
        val nc = col + dc
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
          running = false
        } else if (grid(nr)(nc) == '#' || (nr == obstRow && nc == obstCol)) {
          dir = (dir + 1) % 4
        } else {
          row = nr
          col = nc
        }
      }
    }
    loop
  }

  override def solve(): Int = {
    val lines = read(path)
    val (grid, (startRow, startCol), startDir) = parseGrid(lines)

    // Only test positions the guard actually visits (minus start) — much faster than whole grid
    val candidates = getVisitedPositions(grid, startRow, startCol, startDir) - ((startRow, startCol))

    candidates.count { case (r, c) =>
      causesLoop(grid, startRow, startCol, startDir, r, c)
    }
  }
}
