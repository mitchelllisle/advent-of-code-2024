
import io.github.mitchelllisle.DayOne.{DayOnePartOne, DayOnePartTwo}
import org.scalatest.flatspec.AnyFlatSpec

class TestDayOne extends AnyFlatSpec {
  "DayOnePartOne" should "produce correct output" in {
    val solution = new DayOnePartOne[Int]("src/test/resources/DayOne.txt").solve()
    assert(solution == 11)
  }

  "DayOnePartTwo" should "produce correct output" in {
    val solution = new DayOnePartTwo[Int]("src/test/resources/DayOne.txt").solve()
    assert(solution == 31)
  }
}
