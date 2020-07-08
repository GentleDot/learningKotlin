package chap08

import java.util.*

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)
    val arr2d = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(5, 6, 7))
    val evenArr = Array(5, { i -> i * 2 })
    val nullArr = arrayOfNulls<Int>(100)

    println("arr: ${Arrays.toString(arr)}")     // java.util.Arrays
    println("arr size : ${arr.size}")           // kotlin.IntArray
    println("arr sum : ${arr.sum()}")           // kotlin.collections
    println("다차원 배열 : ${Arrays.deepToString(arr2d)}")       // java.util.Arrays
    println("다차원 배열 : ${arr2d.contentDeepToString()}")      // kotlin.collections
    println("arr: ${Arrays.toString(evenArr)}")     // [0, 2, 4, 6, 8]
    println("arr: ${Arrays.toString(nullArr)}")     // [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
    println("arr: ${Arrays.toString(arr.sliceArray(0..2))}")   // [1, 2, 3]
    println("arr: ${Arrays.toString(arr.plus(6))}")   // [1, 2, 3, 4, 5, 6]

    // getter에 의한 접근, 대괄호 연산자 표기
    println(arr.get(2))
    println(arr[2])

    // setter에 의한 값 설정
    arr.set(2, 7)
    arr[0] = 8
//    arr[6] = 12 // error! (ArrayIndexOutOfBoundsException)

    println("arr: ${Arrays.toString(arr)}")

    // loop를 통한 배열 요쇼의 접근
    for (i in arr.indices) {
        println("arr[$i] = ${arr[i]}")
    }
    /*for (i in 0 until arr.size) {
        println("arr[$i] = ${arr[i]}")
    }
    for (i in 0..arr.size - 1) {
        println("arr[$i] = ${arr[i]}")
    }*/

    // kotlin.collections  활용
    //  - 첫 번째, 마지막 요소 출력
    println(arr.first())
    println(arr.last())

    //  - index의 값 출력
    println("index 3 : ${arr.indexOf(3)}")

    //  - 배열의 평균 값 출력
    println("average: ${arr.average()}")

    //  - 요소 수 확인
    println("count : ${arr.count()}")
    println("count : ${arr.size}")

    //  - 요소가 존재하는지 확인
    println(arr.contains(4))
    println(4 in arr)

    // 배열 순환
    arr.forEach { i -> println(i) }
    arr.forEachIndexed({ index, element -> println("arr[$index] = $element") })

    val iter: Iterator<Int> = arr.iterator()
    while (iter.hasNext()) {
        val e = iter.next()
        println("element : $e")
    }

    arr.sort()
    arr.sortDescending()
    arr.sortedArray()
    arr.sortedArrayDescending()

    val stringArr = arrayOf("Dog", "Lion", "Dinosaur", "aa")
    stringArr.sortBy { item -> item.length }
    stringArr.sortWith(
        Comparator<String> { o1, o2 ->
            when {
                o1.length > o2.length -> 1
                o1.length == o2.length -> 0
                else -> -1
            }
        }
    )

    var arrNumbers = arrayOf(1, 2, -3, -4, 5, 0)
    arrNumbers.filter { i -> i > 0 }.forEach { i -> println(i) }

    val fruits = arrayOf("banana", "avocado", "apple", "kiwi")

    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }

    when {
        "apple" in fruits -> println("Apple included!")
        else -> println("Apple Not Found.")
    }

    println(arrNumbers.maxBy { it })
    println(arrNumbers.minBy { it })

//    val mixedArray = arrayOf(fruits, arrNumbers)
    val mixedArray = arrayOf(fruits, arrayOf("a", "b", "c"))
    val flattenArray = mixedArray.flatten()
    println(flattenArray)

    val int2dArr = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8,9))
    int2dArr.flatten()
}