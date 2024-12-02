package io.github.mitchelllisle.DayTwo

object DayTwoUtils {
  def parse(input: Array[String]): Array[Array[Int]] = {
    input.map(line => {
      line.split("\\s").map(_.toInt)
    })
  }
}
