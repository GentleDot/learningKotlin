package chap08

import java.util.*

val numbers = arrayOf(4, 5, 7, 3)
val array1 = arrayOf(1, 2, 3)
val array2 = arrayOf(4, 5, 6)
val array3 = arrayOf(7, 8, 9)

val arr2d = arrayOf(array1, array2, array3)

val mixArr = arrayOf(4, 5, 3, "name", false)
val newArray = Array<Int>(2) {0}


fun main() {
    for (e1 in arr2d) {
        for (e2 in e1) {
            print(e2)
        }
        println()
    }
    println(Arrays.toString(newArray))
    newArray.get(0)
    newArray.set(1, 1)
    println(Arrays.toString(newArray))
}