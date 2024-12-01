package io.github.mitchelllisle

import org.slf4j.{Logger, LoggerFactory}

import scala.io.Source

trait Solution {

  lazy val logger: Logger = LoggerFactory.getLogger(this.getClass)

  /**
   * Reads the contents of a file at the given path and returns a sequence of strings,
   * where each string represents a line in the file.
   *
   * @param path the path to the file to be read
   * @return a sequence of strings, each representing a line in the file
   */
  def read(path: String): Seq[String] = {
    val source = Source.fromFile(path)
    try {
      source.getLines().toSeq
    } finally {
      source.close()
    }
  }

  def printSolution[T](): Unit = {
    val solution = solve[T]()
    logger.info(s"${this.getClass.getSimpleName} Solution: $solution")
  }

  /**
   * Solves the problem.
   * Implement this method in your weekly solution.
   */
  def solve[T](): T
}
