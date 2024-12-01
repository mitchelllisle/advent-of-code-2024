package io.github.mitchelllisle.DayOne

import scala.collection.mutable.ArrayBuffer

object DayOneUtils {
  def parse(input: Array[String]): Array[(Int, Int)] = {
    val left = ArrayBuffer.empty[Int]
    val right = ArrayBuffer.empty[Int]

    input.foreach(line => {
      // input file is always split with three spaces
      val split = line.split("\\s{3}", 2)
      left += split(0).toInt
      right += split(1).toInt
    })
    left.toArray.sorted.zip(right.toArray.sorted)
  }
}
