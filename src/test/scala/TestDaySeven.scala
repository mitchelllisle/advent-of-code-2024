import io.github.mitchelllisle.DaySeven.{DaySevenPartOne, DaySevenPartTwo}
import org.scalatest.flatspec.AnyFlatSpec

class TestDaySeven extends AnyFlatSpec {
  "DaySevenPartOne" should "produce correct output" in {
    val solution = new DaySevenPartOne("src/test/resources/DaySeven.txt").solve()
    assert(solution == 3749L)
  }

  "DaySevenPartTwo" should "produce correct output" in {
    val solution = new DaySevenPartTwo("src/test/resources/DaySeven.txt").solve()
    assert(solution == 11387L)
  }
}
