package chapter2.exercises.ex1

import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import kotlinx.collections.immutable.persistentMapOf

//TODO: Enable tests by removing `!` prefix
class Exercise1 : WordSpec({
    //tag::init[]
    fun fib(n: Int, s: String): Int {
        println("fib $s of $n")
        // This is exactly the same as a ternary expression
        return if (n < 2) {
            n
        }
        else {
            println(" calculating ${n}")
            val left = fib(n - 1, "left")
            val right = fib(n - 2, "right")
            println("  total: ${left}+${right}")
            left + right
        }
    }
    //end::init[]

    "fib" should {
        "return the nth fibonacci number" {
            persistentMapOf(
                1 to 1,
                2 to 1,
                3 to 2,
                4 to 3,
                5 to 5,
                6 to 8,
                7 to 13,
                8 to 21
            ).forEach { (n, num) ->
                fib(n, ">>") shouldBe num
            }
        }
    }
})
