package chap09

fun main() {
    val langMap = mapOf(11 to "java", 22 to "Kotlin", 33 to "C++")
    println(langMap)

    for ((key, value) in langMap) {
        println("key = $key, value = $value")
    }

    println("langMap[22] = ${langMap[22]}")
    println("langMap.get(22) = ${langMap.get(22)}")
    println("langMap.keys = ${langMap.keys}")
}