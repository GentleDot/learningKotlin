package chap11

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

//var counter = 0 // 병행 처리중 문제가 발생할수 있는 변수, 무결성을 보장할 안전장치 없음
var counter = AtomicInteger(0) // 원자 변수로 초기화
suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 1000 // 실행할 코루틴의 수
    val k = 1000 // 각 코루틴을 반복할 수
    val time = measureTimeMillis {
        val jobs = List(n) {
            GlobalScope.launch {
                repeat(k) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n * k} actions in $time ms")
}

fun main() = runBlocking<Unit> {
    massiveRun {
        // counter++ // 중가 연산 시 값의 무결성에 문제가 발생할 수 있옴
        counter.incrementAndGet() // 원자변수의 member method를 사용해 증가
    }
//    println("Counter = $counter")
    println("Counter = ${counter.get()}")
}