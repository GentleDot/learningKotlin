package chap03

fun main() {
    val square1: (Int, Int) -> Int = { x, y ->
        println("x * y")
        x * y
    }
    val greet: () -> Unit = { println("Hello, world!") }
    val square2: (Int) -> Int = { x -> x * x }

    val nestedLambda: () -> () -> Unit = { { println("nested!") } }

    val square3 = { x: Int -> x * x }

//    val out = { println("Hello, World!") }
    val out: () -> Unit = { println("Hello, World!") }
    out()
    val new = out
    new()

    val onlyTrue = callByValue(lambdaProperty())
    val thisIsTrue = callByLambda(lambdaProperty)
    println(onlyTrue)
    println(thisIsTrue)
}

private fun callByValue(b: Boolean): Boolean {
    println("callByValue 호출 : $b")
    return b
}

private fun callByLambda(b: () -> Boolean): Boolean {
    println("callByValue 호출 : $b")
    return b()
}

val lambdaProperty: () -> Boolean = {
    println("lambdaProperty 호출")
    true
}