package chap11

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

// 단일 thread context를 선언
val counterContext = newSingleThreadContext("CounterContext")
var counter2 = 0
suspend fun massiveRun(context: CoroutineContext, action: suspend () -> Unit) {
    val n = 1000
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n) {
            GlobalScope.launch(context) { repeat(k) { action() } }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${n * k} actions in $time ms")
}

fun main() = runBlocking<Unit> {
    massiveRun(counterContext) { // GlobalScope에서 counter2++ lunch되는 구문을 GlobalScope 내에서 해당 counterContext 에서 처리
        counter2++
    }
    println("Counter = $counter2")
}