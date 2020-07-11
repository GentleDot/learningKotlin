package chap09

fun main() {
    val mixedTypeSet = setOf("Hello", 5, "world", 3.14, 'c') // 자료형 혼합
    var intSet = setOf<Int>(1, 5, 5)

    println(mixedTypeSet) // [Hello, 5, world, 3.14, c]
    println(intSet) // [1, 5]
}