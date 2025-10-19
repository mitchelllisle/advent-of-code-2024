import io.github.mitchelllisle.DayFour.{DayFourPartOne, DayFourPartTwo}
import org.scalatest.flatspec.AnyFlatSpec

class TestDayFour extends AnyFlatSpec {
  "DayFourPartOne" should "produce correct output" in {
    val solution = new DayFourPartOne("src/test/resources/DayFour.txt").solve()
    assert(solution == 18)
  }

  "DayFourPartTwo" should "produce correct output" in {
    val solution = new DayFourPartTwo("src/test/resources/DayFour.txt").solve()
    assert(solution == 9)
  }
}
