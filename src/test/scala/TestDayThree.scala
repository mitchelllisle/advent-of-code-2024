import io.github.mitchelllisle.DayThree.{DayThreePartOne, DayThreePartTwo}
import org.scalatest.flatspec.AnyFlatSpec

class TestDayThree extends AnyFlatSpec {
  "DayThreePartOne" should "produce correct output" in {
    val solution = new DayThreePartOne("src/test/resources/DayThreePartOne.txt").solve()
    assert(solution == 161)
  }

  "DayThreePartTwo" should "produce correct output" in {
    val solution = new DayThreePartTwo("src/test/resources/DayThreePartTwo.txt").solve()
    assert(solution == 48)
  }
}
