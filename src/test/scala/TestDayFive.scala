import io.github.mitchelllisle.DayFive.{DayFivePartOne, DayFivePartTwo}
import org.scalatest.flatspec.AnyFlatSpec

class TestDayFive extends AnyFlatSpec {
  "DayFivePartOne" should "produce correct output" in {
    val solution = new DayFivePartOne("src/test/resources/DayFive.txt").solve()
    assert(solution == 143)
  }

  "DayFivePartTwo" should "produce correct output" in {
    val solution = new DayFivePartTwo("src/test/resources/DayFive.txt").solve()
    assert(solution == 123)
  }
}

