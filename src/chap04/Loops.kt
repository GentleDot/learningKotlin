package chap04

fun main() {
    var sum = 0

    for (x in 1..5) {
        sum += x    // 1 + 2 + 3 + 4 + 5
    }

    for (x in 1..5 step 2) sum += x

    println(sum)

//    for (i in 5.downTo(1)) sum += i
    for (i in 5 downTo 1) sum += i
    // for (i in 5..1) sum += i // 동작하지 않음

    println(sum)

    for (i in 1..5 step 2) println(i)

    forTriangle()

    var i = 1
    while (i <= 5) {
        println(i)
        i++
    }

    do {
        println(i)
        i++
    } while (i<= 10)
}

fun forTriangle() {
    print("Enter the lines : ")
    var n = readLine()?.toInt()

    if (n == null) n = 1

    for (line in 1..n) {
        for (space in 1..(n - line)) print(" ")
//        for (star in 1 until (2 * line)) print("*")
        for (star in 1..(2 * line - 1)) print("*")
        println() // 개행
    }
}