import io.github.mitchelllisle.DayOne

import org.scalatest.flatspec.AnyFlatSpec

class TestDayOne extends AnyFlatSpec {
  "DayOne" should "produce correct output" in {
    val solution = new DayOne("src/test/resources/DayOne.txt").solve[Int]()
    assert(solution == 11)
  }
}
