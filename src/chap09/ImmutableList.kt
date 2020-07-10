package chap09

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val names = listOf("one", "two", "three")
    var mixedArr = listOf("hello", 1, 2.445, 's') // 형식 매개변수 생략 (Any)
    val emptyList = emptyList<String>() // 빈 리스트 생성
    val nonNullList = listOfNotNull(2, 45, null, 5, null) // [2, 45, 2, 5]

    for (name: String in names) {
        println(name)
    }

    for (num in numbers) print(num)
    println()

    val fruits = listOf("apple", "banana", "kiwi")

    for (item in fruits) {
        print("$item ")
    }
    println()

    for (index in fruits.indices) {
        print("fruits[$index] = ${fruits[index]} ")
    }
    println()

    /*emptyList.get()
    emptyList.indexOf()
    emptyList.lastIndexOf()
    emptyList.listIterator()
    emptyList.subList()*/
}