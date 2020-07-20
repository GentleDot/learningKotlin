package chap11

import kotlinx.coroutines.*

fun main() = runBlocking {
//    runRepeat()
//    jobDone()
//    doTryAndFinally()
//    loopWithisActive()

    /*try {
        withTimeout(1300) {
            repeat(1000) { i ->
                println("print $i ...")
                delay(500L)
            }
        }
    } catch (e: TimeoutCancellationException) {
        println("Timed out! with $e")
    }*/

    val jobOrNull = withTimeoutOrNull(1300) {
        repeat(1000) { i ->
            println("print $i ...")
            delay(500L)
        }
    }
    println("작업 완료! 반환 : $jobOrNull")
}

private suspend fun loopWithisActive() {
    val startTime = System.currentTimeMillis()
    val job = GlobalScope.launch {
        var nextPrintTime = startTime
        var i = 0

        // 조건식 내 연산이 마무리되기 쩐까지는 routine이 중단되지 않음
//        while (i < 5) {
        // 활성 상태를 파악해 종료시킴
        while (isActive) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("I'm sleeping ${i++}")
                nextPrintTime += 500L
            }
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Quit!")
}

private suspend fun CoroutineScope.doTryAndFinally() {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("print $i ...")
                delay(500)
            }
        } finally {
//             println("Bye!")
            // finally의 완전한 실행 보장
            withContext(NonCancellable) {
                println("Finally! Done.")
                delay(1000L) // 1초 지연되도 취소되지 않음
                println("Bye!")
            }
        }
    }
    delay(1300L)
    job.cancelAndJoin() // 작업을 취소하고 완료될 때까지 대기
    println("main : Quit!")
}

private suspend fun CoroutineScope.jobDone() {
    val request = launch {
        repeat(3) { i ->
            launch {
                delay((i + 1) * 200L)
                println("Coroutine $i is done!")
            }
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }

    request.join()
    println("request complete!")
}

private suspend fun runRepeat() {
    GlobalScope.launch {
        repeat(1000) { i ->
            println("print $i ...")
            delay(500)
        }
    }
    delay(1300) // main thread가 종료되면 GlobalScope.launch 작업은 더 이상 진행되지 않음
}