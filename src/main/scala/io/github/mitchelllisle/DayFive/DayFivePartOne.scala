package io.github.mitchelllisle.DayFive

import io.github.mitchelllisle.Solution

class DayFivePartOne(path: String) extends Solution[Int] {

  private def parseInput(lines: Array[String]): (Map[Int, Set[Int]], List[List[Int]]) = {
    val splitIndex = lines.indexOf("")
    val rules = lines.take(splitIndex)
    val updates = lines.drop(splitIndex + 1).filter(_.nonEmpty)

    // Parse rules: X|Y means X must come before Y
    // Store as a map: page -> set of pages that must come after it
    val rulesMap = rules.foldLeft(Map.empty[Int, Set[Int]]) { (acc, line) =>
      val parts = line.split("\\|")
      val before = parts(0).toInt
      val after = parts(1).toInt
      acc + (before -> (acc.getOrElse(before, Set.empty) + after))
    }

    // Parse updates: comma-separated page numbers
    val updatesList = updates.map(_.split(",").map(_.toInt).toList).toList

    (rulesMap, updatesList)
  }

  private def isValidOrder(update: List[Int], rules: Map[Int, Set[Int]]): Boolean = {
    // For each pair of pages in the update, check if they violate any rule
    update.indices.forall { i =>
      val currentPage = update(i)
      val pagesAfter = rules.getOrElse(currentPage, Set.empty)

      // Check if any page before current position should actually come after
      val pagesBefore = update.take(i).toSet
      pagesBefore.intersect(pagesAfter).isEmpty
    }
  }

  private def getMiddlePage(update: List[Int]): Int = {
    update(update.length / 2)
  }

  override def solve(): Int = {
    val lines = read(path)
    val (rules, updates) = parseInput(lines)

    updates
      .filter(update => isValidOrder(update, rules))
      .map(getMiddlePage)
      .sum
  }
}
