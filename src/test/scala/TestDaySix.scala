import io.github.mitchelllisle.DaySix.{DaySixPartOne, DaySixPartTwo}
import org.scalatest.flatspec.AnyFlatSpec

class TestDaySix extends AnyFlatSpec {
  "DaySixPartOne" should "produce correct output" in {
    val solution = new DaySixPartOne("src/test/resources/DaySix.txt").solve()
    assert(solution == 41)
  }

  "DaySixPartTwo" should "produce correct output" in {
    val solution = new DaySixPartTwo("src/test/resources/DaySix.txt").solve()
    assert(solution == 6)
  }
}
