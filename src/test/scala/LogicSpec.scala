import org.specs2.mutable.Specification

object LogicSpec extends Specification {
  "The 'matchLikelihood' method" should {
    "be 100% when all attributes match" in {
      val tabby = Kitten(1, List("x", "y"))
      val prefs = BuyerPreferences(List("x", "y"))
      val result = Logic.matchLikelihood(tabby, prefs)
      result must beGreaterThan(0.999)
    }
    "be 0% when no attributes match" in {
      val tabby = Kitten(1, List("x", "y"))
      val prefs = BuyerPreferences(List("a", "b"))
      val result = Logic.matchLikelihood(tabby, prefs)
      result must beLessThan(0.001)
    }
  }

}
