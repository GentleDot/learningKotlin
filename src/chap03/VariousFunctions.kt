package chap03

import java.math.BigInteger

fun main() {
    /*shortFunc(3) { println("First call: $it") }
    shortFunc(5) { println("Second call: $it") }
    shortFunc(7) {
        println("Third Call : $it")
//        return
    }
    shortFunc2(7) {
        println("Fourth Call : $it")
    }

    val source = "Hello, World"
    val target = "Kotlin"

    println(source.getLongString(target))

//    val multi = 3.multiply(10)
    val multi = 3 multiply 10

    println(multi)*/

    /*val number = 4
    val result: Long
    val result2: Long

    result = factorial(number)
    println("Factorial 결과 : $number -> $result")
    println("Factorial 결과 : $number -> ${factorialWithTailrec(number)}")*/

    val n = 7
    val first = 0L
    val second = 1L

    println(fibonacci(n, first, second))

    println(fibonacciWithBigInteger(100, BigInteger("0"), BigInteger("1")))
}

inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Before calling out()")
    out(a)
    println("After calling out()")
}

inline fun shortFunc2(a: Int, crossinline out: (Int) -> Unit) {
    println("Before calling out()")
    nestedFunc { out(a) }
    println("After calling out()")
}

fun nestedFunc(body: () -> Unit) {
    body()
}

fun String.getLongString(target: String): String {
    return if (this.length > target.length) this else target
}

infix fun Int.multiply(x: Int) = this * x

fun factorial(n: Int): Long {
    return if (n == 1) n.toLong() else n * factorial(n - 1)
}

tailrec fun factorialWithTailrec(n: Int, run: Int = 1): Long {
    return if (n == 1) run.toLong() else factorialWithTailrec(n - 1, run * n)
}

fun fibonacci(n: Int, a: Long, b: Long): Long {
    return if (n == 0) a else fibonacci(n - 1, a + b, a)
}

tailrec fun fibonacciWithBigInteger(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) a else fibonacciWithBigInteger(n - 1, b, a + b)
}