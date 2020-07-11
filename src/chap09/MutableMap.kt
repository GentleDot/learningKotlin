package chap09

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

fun main() {
    val capitalCityMap = mutableMapOf("Korea" to "Seoul", "China" to "Beijing", "Japan" to "Tokyo")
    println(capitalCityMap)

    capitalCityMap.put("UK", "London")
    capitalCityMap.remove("China")

    println(capitalCityMap)
    println(capitalCityMap.keys)
    println(capitalCityMap.values)

    val addData = mutableMapOf("USA" to "Washington")
    capitalCityMap.putAll(addData) //  putAll을 통해 map에 collection 추가
    println(capitalCityMap)

    // Java.util.HashMap 사용
    val hashMap: HashMap<Int, String> = hashMapOf(1 to "Hello", 2 to "World")
    println("hashMap = $hashMap")

    // java.util.SortedMap 사용
    val sortedMap: SortedMap<Int, String> = sortedMapOf(1 to "Apple", 2 to "Banana")
    println("sortedMap = $sortedMap")

    // java.util.LinkedHashMap 사용
    val linkedHash: LinkedHashMap<Int, String> = linkedMapOf(1 to "Computer", 2 to "Mouse")
    println("linkedHash = $linkedHash")
}