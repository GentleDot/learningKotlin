package chap03

fun main() {
    val res1 = funcParam(3, 2, ::sum)
    println(res1)

    hello(::text)

    val likeLambda = ::sum
    println(likeLambda(6, 6))

    noParam({ "hello world" })
    noParam() { "hello world" }
    noParam { "hello world" }

    oneParam { a -> "hello world! $a" }
    oneParam { "hello world! $it" }

    moreParam({ s, s2 -> "hello, world! $s, $s2" })
    moreParam() { s, s2 -> "hello, world! $s, $s2" }
    moreParam { s, s2 -> "hello, world! $s, $s2" }
    moreParam { _, s2 -> "hello, world! $s2" }

    withArgs("arg1", "arg2", { a, b -> "hello world! $a, $b" })
    withArgs("arg1", "arg2") { a, b -> "hello world! $a, $b" }
}

private fun sum(a: Int, b: Int) = a + b

private fun text(a: String, b: String) = "Hello! $a and $b"

private fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

private fun hello(body: (String, String) -> String) {
    println(body("hello", "world"))
}

fun noParam(out: () -> String) = println(out())

fun oneParam(out: (String) -> String) {
    println(out("this is a pen."))
}

fun moreParam(out: (String, String) -> String) = println(out("one", "two"))

fun withArgs(a: String, b: String, out: (String, String) -> String) {
    println(out(a, b))
}