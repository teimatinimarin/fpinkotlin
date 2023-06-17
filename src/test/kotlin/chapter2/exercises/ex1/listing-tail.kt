package chapter2.exercises.ex1

import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import kotlinx.collections.immutable.persistentMapOf

class Exercise1_Tail : WordSpec({
    //tag::init[]
    fun fib(n: Int, acc: Int = 0, prev: Int = 1, s: String): Int {
        println("$s fib of $n")
        return if (n < 1) {
            println(" return $acc")
            acc
        }
        else {
            println(" rec ${n-1}, ${prev+acc}, $acc")
            fib(n - 1, prev + acc, acc, "[${n-1}]")
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
                fib(n, s = ">>") shouldBe num
            }
        }
    }
})
