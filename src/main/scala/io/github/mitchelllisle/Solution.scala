package io.github.mitchelllisle

import org.slf4j.{Logger, LoggerFactory}

import scala.io.Source

trait Solution[T] {

  lazy val logger: Logger = LoggerFactory.getLogger(this.getClass)

  /**
   * Reads the contents of a file at the given path and returns a sequence of strings,
   * where each string represents a line in the file.
   *
   * @param path the path to the file to be read
   * @return a sequence of strings, each representing a line in the file
   */
  def read(path: String): Array[String] = {
    val source = Source.fromFile(path)
    try {
      source.getLines().toArray
    } finally {
      source.close()
    }
  }

  def printSolution(): Unit = {
    val start = System.currentTimeMillis()
    val solution = solve()
    val end = System.currentTimeMillis()
    logger.info(s"${this.getClass.getSimpleName} Solution: $solution. Took ${end - start}ms")
  }

  /**
   * Solves the problem.
   * Implement this method in your weekly solution.
   */
  def solve(): T
}
