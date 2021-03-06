package chap11

import kotlinx.coroutines.*

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception -> // 예외 핸들러 정의
        println("Caught $exception")
    }
    val supervisor = SupervisorJob()
//    val supervisor = Job()
    with(CoroutineScope(coroutineContext + supervisor)) {
        val firstChild = launch(handler) { // 첫번째 자식 코루틴 생성 -- 예외처리 문맥을 가짐
            println("First child is failing")
            throw AssertionError("First child is cancelled") // 실패를 가정한 exception 발생,
        }
        val secondChild = launch {// 두번째 자식 코루틴 생성
            firstChild.join()
            // 첫번째 자식 코루틴의 취소가 이 코루틴에 영향을 주지 않는다.
            println("firstChild.isCancelled: ${firstChild.isCancelled}, but second one is still active")
            try {
                delay(Long.MAX_VALUE)
            } finally {
                // 하지만 supervisor의 취소는 영향을 받게된다.
                println("Second child is cancelled because supervisor is cancelled")
            }
        }

        firstChild.join() // 첫번째 자식의 실패나 완료를 기다림
        println("Cancelling supervisor")
        supervisor.cancel()
        secondChild.join()
    }
}