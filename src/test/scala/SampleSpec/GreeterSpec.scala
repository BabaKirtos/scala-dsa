package SampleSpec

import Sample.Greeter
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class GreeterSpec extends AnyWordSpecLike with Matchers {

  "The Greeter object" should {

    "return a greeting message" when {
      
      "a name is provided" in {
        val result = Greeter.greet("Alice")
        result should be("Hello, Alice!")
      }

      "an empty name is provided" in {
        val result = Greeter.greet("")
        result should be("Hello, !")
      }

      "a null name is provided" in {
        // Assuming that our function gracefully handles null input
        // This might need to be adjusted based on actual implementation
        val result = Greeter.greet(null)
        result should be("Hello, null!")
      }
    }
  }
}
