package chap11

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

suspend fun doWork1(): String {
    delay(1000L)
    return "Work1"
}

suspend fun doWork2(): String {
    delay(3000L)
    return "Work2"
}

private fun worksInSerial(): Job {
    // 순차적 실행
    val job = GlobalScope.launch {
        val one = doWork1()
        val two = doWork2()
        println("Kotlin One : $one")
        println("Kotlin Two : $two")
    }

    return job
}

private fun worksInParalllel() {
    // Deferred<T> 를 통해 결과값을 반환
    val one = GlobalScope.async {
        println("work1")
        doWork1()
    }
    val two = GlobalScope.async {
        println("work2")
        doWork2()
    }

    GlobalScope.launch {
        val combined = one.await() + "_" + two.await()
        println("work combined : $combined")
    }
}

fun tempThreadPool() {
    val threadPool = Executors.newFixedThreadPool(4)
    val myContext = threadPool.asCoroutineDispatcher()

    GlobalScope.async(myContext) {  }
}

fun main() = runBlocking { // main()이 coroutine 환경에서 실행
    val time = measureTimeMillis {
        val job = worksInSerial()
        job.join()
    }
//    worksInParalllel()
//    readLine() // main()이 먼저 종료되는 것을 방지하기 위해 콘솔에서 enter 키 입력 대기

    println("걸린 시간 확인 : $time")
}