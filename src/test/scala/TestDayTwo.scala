import io.github.mitchelllisle.DayTwo.DayTwoPartOne
import org.scalatest.flatspec.AnyFlatSpec

class TestDayTwo extends AnyFlatSpec {
  "DayTwoPartOne" should "return correct output" in {
    val dayTwoPartOne = new DayTwoPartOne[Int]("src/test/resources/DayTwo.txt")
    assert(dayTwoPartOne.solve() == 2)
  }
}
