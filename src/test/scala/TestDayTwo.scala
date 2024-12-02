import io.github.mitchelllisle.DayTwo.{DayTwoPartOne, DayTwoPartTwo}
import org.scalatest.flatspec.AnyFlatSpec

class TestDayTwo extends AnyFlatSpec {
  "DayTwoPartOne" should "return correct output" in {
    val dayTwoPartOne = new DayTwoPartOne("src/test/resources/DayTwo.txt")
    assert(dayTwoPartOne.solve() == 2)
  }

  "DayTwoPartTwo" should "return correct output" in {
    val dayTwoPartTwo = new DayTwoPartTwo("src/test/resources/DayTwo.txt")
    assert(dayTwoPartTwo.solve() == 4)
  }
}
