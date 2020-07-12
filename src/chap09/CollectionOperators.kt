package chap09

fun main() {
    val list1 = listOf("one", "two", "three")
    val list2 = listOf(1, 3, 4)
    val map1 = mapOf("hi" to 1, "hello" to 2, "Goodbye" to 3)

    println(list1 + "four")
    println(list2 + 1)
    println(list2 + listOf(5, 6, 7))
    println(list2 - 1)
    println(list2 - listOf(3, 4, 5))
    println(map1 + Pair("Bye", 4))
    println(map1 - "hello")
    println(map1 + mapOf("Apple" to 4, "Orange" to 5))
    println(map1 - listOf("hi", "hello"))

    val list = listOf(1, 2, 3, 4, 5, 6)

    list.forEach { println(it) }
    println()

    list.forEachIndexed { index, i -> println("index[$index]: $i") }
    val returnedList = list.onEach { println(it) }
    println()
    println("returnedList : $returnedList")

    println(list.fold(4) { acc, i -> acc + i })
    println(list.foldRight(4) { acc, i -> acc + i })
    println(list.fold(1) { total, next -> total * next })
    println(list.reduce({ acc, i -> acc + i }))
    println(list.reduceRight({ total, next -> total * next }))

    val listWithNull = listOf(1, null, 3, null, 5, 6)
    println(listWithNull)

    println(list.filter { it % 2 == 0 })
    println(list.filterNot { it % 2 == 0 })
    println(listWithNull.filterNotNull())
    println("filterIndexed : ${list.filterIndexed { index, i -> index != 1 && i % 2 == 0 }}") // filterIndexed : [4, 6]

    val mutList = list
        .filterIndexedTo(mutableListOf()) { index, i -> index != 1 && i % 2 == 0 }
    println("filterIndexedTo : $mutList") // filterIndexedTo : [4, 6]

    println("filterKeys : ${map1.filterKeys { it != "hi" }}") // filterKeys : {hello=2, Goodbye=3}
    println("filterValues : ${map1.filterValues { it != 2 }}") // filterValues : {hi=1, Goodbye=3}

    val listMixed = listOf(1, "hi", 3, "nice", 5, 'c')
    println("filterIsInstance<String>: ${listMixed.filterIsInstance<String>()}") // filterIsInstance<String>: [hi, nice]

    println(list.slice(2..4)) // [3, 4, 5]
    println(list.slice(listOf(0, 1, 2))) // [1, 2, 3]

    println(list.take(2)) // [1, 2]
    println(list.takeLast(2)) // [5, 6]
    println(list.takeWhile { it < 3 }) // [1, 2]
    println(list.drop(2)) // [3, 4, 5, 6]
    println(list.dropLast(2)) // [1, 2, 3, 4]
    println(list.dropWhile { it < 3 }) // [3, 4, 5, 6]

    val listRepeated = listOf(3, 3, 4, 5, 5, 5, 5, 6, 6)
    println("distinct: ${listRepeated.distinct()}") // distinct: [3, 4, 5, 6]
    println("intersect: ${list.intersect(listOf(5, 6, 7, 8))}") // intersect: [5, 6]

    println(list.map { it * 2 }) // [2, 4, 6, 8, 10, 12]
    println(list.mapIndexed {index, i -> index * i }) // [0, 2, 6, 12, 20, 30]
    println(listWithNull.mapNotNull { it?.times(2) }) // [2, 6, 10, 12]

    println(list.flatMap { listOf(it, 'A') }) // [1, A, 2, A, 3, A, 4, A, 5, A, 6, A]
    val result = listOf("abc", "12").flatMap { it.toList() }
    println(result) // [a, b, c, 1, 2]

    println(list.groupBy { if (it % 2 == 0) "even" else "odd" }) // {odd=[1, 3, 5], even=[2, 4, 6]}

    println("elementAt: ${list.elementAt(1)}") // elementAt: 2
//    println("elementAt: ${list.elementAtOrElse(10, {2 * it})}")
    println("elementAt: ${list.elementAtOrElse(10) {2 * it}}") // elementAt: 20
    println("elementAtOrNull: ${list.elementAtOrNull(10)}") // elementAtOrNull: null

    println(list.reversed()) // [6, 5, 4, 3, 2, 1]
    println(list.sorted()) // [1, 2, 3, 4, 5, 6]
    println(list.sortedDescending()) // [6, 5, 4, 3, 2, 1]
    println(list.sortedBy { it % 3 }) // [3, 6, 1, 4, 2, 5]
    println(list.sortedByDescending { it % 3 }) // [2, 5, 1, 4, 3, 6]
}