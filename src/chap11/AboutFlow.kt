package chap11

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

/*
// suspend 키워드 없이 지연 제공
fun foo() = flow {
    for (i in 1..3) {
        delay(100) // cpu 소비 중으로 가정
        emit(i) // 지속적으로 다음 값을 방출
    }
}

fun main() = runBlocking {
    launch {
        // main thread와 함께 병행적으로 처리되는지 확인하기 위한 for문
        for (k in 1..3) {
            println("not Blocked $k")
            delay(100)
        }
    }

    // flow에서 값 수집
    foo().collect {value -> println(value)  }
}*/

val ints: Flow<Int> = flow {
    for (i in 1..10) {
        delay(100)
        emit(i)
    }
}

suspend fun main() {
    val time = measureTimeMillis {
        ints.collect {
            println(it)
        }
    }
    println("Collected in $time ms")
}
