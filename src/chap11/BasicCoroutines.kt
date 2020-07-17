package chap11

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() { // main thread의 context
    // 새로운 coroutine 을 background에 실행
    GlobalScope.launch {
        delay(1000L) // 1초 = 1000ms, non-blocking 지연
        println("Hello World!") // 지연 후 출력
    }
    println("with Coroutines.") // main thread가 coroutine이 지연되는 동안 계속 실행
    Thread.sleep(2000L) // main thread가 JVM에서 바로 종료되지 않게 2초 대기
}