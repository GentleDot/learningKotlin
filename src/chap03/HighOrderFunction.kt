package chap03

fun main() {
    println(highFunc({ x, y -> x + y }, 1, 2))

    var result: Int


    val multi: (Int, Int) -> Int = { x: Int, y: Int -> x * y }
//    val multi = {x: Int, y: Int -> x * y}
//    val multi: (Int, Int) -> Int = {x, y -> x * y}
//    val multi = {x, y -> x * y}

    result = multi(10, 2)
    println(result)
}

fun highFunc(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}