package io.github.mitchelllisle.DayFive

import io.github.mitchelllisle.Solution

import scala.collection.mutable

class DayFivePartTwo(path: String) extends Solution[Int] {

  private def parseInput(lines: Array[String]): (Map[Int, Set[Int]], List[List[Int]]) = {
    val splitIndex = lines.indexOf("")
    val rules = lines.take(splitIndex)
    val updates = lines.drop(splitIndex + 1).filter(_.nonEmpty)

    // Parse rules: X|Y means X must come before Y
    val rulesMap = rules.foldLeft(Map.empty[Int, Set[Int]]) { (acc, line) =>
      val parts = line.split("\\|")
      val before = parts(0).toInt
      val after = parts(1).toInt
      acc + (before -> (acc.getOrElse(before, Set.empty) + after))
    }

    val updatesList = updates.map(_.split(",").map(_.toInt).toList).toList

    (rulesMap, updatesList)
  }

  private def isValidOrder(update: List[Int], rules: Map[Int, Set[Int]]): Boolean = {
    update.indices.forall { i =>
      val currentPage = update(i)
      val pagesAfter = rules.getOrElse(currentPage, Set.empty)
      val pagesBefore = update.take(i).toSet
      pagesBefore.intersect(pagesAfter).isEmpty
    }
  }

  private def reorderUpdate(update: List[Int], rules: Map[Int, Set[Int]]): List[Int] = {
    // Topological sort using only the pages in this update
    val pages = update.toSet
    val relevantRules = rules.map { case (k, v) => (k, v.intersect(pages)) }

    // Build in-degree map
    val inDegree = mutable.Map.empty[Int, Int].withDefaultValue(0)
    pages.foreach(page => inDegree(page) = 0)

    relevantRules.foreach { case (before, afters) =>
      if (pages.contains(before)) {
        afters.foreach { after =>
          inDegree(after) += 1
        }
      }
    }

    // Kahn's algorithm for topological sort
    val queue = mutable.Queue.empty[Int]
    inDegree.foreach { case (page, degree) =>
      if (degree == 0) queue.enqueue(page)
    }

    val result = mutable.ListBuffer.empty[Int]
    while (queue.nonEmpty) {
      val current = queue.dequeue()
      result += current

      relevantRules.getOrElse(current, Set.empty).foreach { after =>
        inDegree(after) -= 1
        if (inDegree(after) == 0) {
          queue.enqueue(after)
        }
      }
    }

    result.toList
  }

  private def getMiddlePage(update: List[Int]): Int = {
    update(update.length / 2)
  }

  override def solve(): Int = {
    val lines = read(path)
    val (rules, updates) = parseInput(lines)

    updates
      .filterNot(update => isValidOrder(update, rules))
      .map(update => reorderUpdate(update, rules))
      .map(getMiddlePage)
      .sum
  }
}
