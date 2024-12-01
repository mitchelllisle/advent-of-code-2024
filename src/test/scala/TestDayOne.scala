import io.github.mitchelllisle.DayOne

import org.scalatest.flatspec.AnyFlatSpec

class TestDayOne extends AnyFlatSpec {
  "DayOne" should "produce correct output" in {
    val solution = new DayOne[Int]("src/test/resources/DayOne.txt").solve()
    assert(solution == 11)
  }
}
