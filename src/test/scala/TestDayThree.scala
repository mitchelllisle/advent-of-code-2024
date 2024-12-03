import io.github.mitchelllisle.DayThree.DayThreePartOne
import org.scalatest.flatspec.AnyFlatSpec

class TestDayThree extends AnyFlatSpec {
  "DayThreePartOne" should "produce correct output" in {
    val solution = new DayThreePartOne("src/test/resources/DayThree.txt").solve()
    assert(solution == 161)
  }
}
