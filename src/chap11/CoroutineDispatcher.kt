package chap11

import kotlinx.coroutines.*

fun main() = runBlocking {
    val jobs = arrayListOf<kotlinx.coroutines.Job>()

    jobs += launch(Dispatchers.Unconfined) {
        // main thread에서 작업
        // 지연 함수를 만나면 분리되어 독립 (kotlinx.coroutines.DefaultExecutor)
        println("Unconfined :\t\t ${this.coroutineContext}, ${Thread.currentThread()}")
        delay(100L)
        println("Unconfined :\t\t ${this.coroutineContext}, ${Thread.currentThread()}") // 지연함수를 만난 다음에는 작업을 재개하기 위해 thread가 분리
    }

    jobs += launch(coroutineContext) {
        // 부모의 문맥 (runBlocking 문맥)
        println("coroutineContext :\t\t ${this.coroutineContext}, ${Thread.currentThread()}")
    }

    jobs += launch(Dispatchers.Default) {
        // Dispatcher의 기본값
        println("Default :\t\t ${this.coroutineContext}, ${Thread.currentThread()}")
    }

    jobs += launch(Dispatchers.IO) {
        // 입출력 중심의 context (LimitingDispatcher)
        println("IO :\t\t ${this.coroutineContext}, ${Thread.currentThread()}")
    }

    jobs += launch {
        // 아무런 인자가 없다면 부모(runBlocking)의 context 상속
        println("main runBlocking :\t\t ${this.coroutineContext}, ${Thread.currentThread()}")
    }

    jobs += launch(newSingleThreadContext("myThread")) {
        // 새로운 thread를 생성
        println("myThread :\t\t ${this.coroutineContext}, ${Thread.currentThread()}")
    }

    jobs.forEach{ it.join()}

}