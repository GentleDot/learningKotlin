package chap10

import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {
    data class SomeObject(var status: Boolean)

    val someObject = SomeObject(true)

    // 기존 코드
    if (someObject != null && someObject.status) {
        println("OK!")
    }

    // 개선 코드
    if (someObject?.status == true) {
        println("OK!")
    }

    // takeIf 사용 코드
    someObject?.takeIf { it.status }?.apply { println("OK!") }

    val input = "Kotlin"
    val keyword = "in"

    // 입력 문자열에 키워드가 있으면 index를 반환하는 함수
    println(input.indexOf(keyword).takeIf { it >= 0 } ?: error("keyword not found!"))

    // takeUnless 사용하여 구현
    println(input.indexOf(keyword).takeUnless { it < 0 } ?: error("keyword not found!"))

    val executionTime = measureTimeMillis {
        Thread.sleep(60)
    }
    println("Execution Time : $executionTime ms")

    val randomInt = Random.nextInt(21) // 난수 발생 범위 지정 (0 ~ 20)
    val randomDouble = Random.nextDouble(1.0) // 난수 발생 범위 지정 (0 ~ 0.9999_9999_9999_9999)
    println(randomInt)
    println(randomDouble)
}