package chap11

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("runBlocking : $coroutineContext")
    val request = launch {
        println("request : $coroutineContext")
        GlobalScope.launch {
            println("Job1: before suspend function. / $coroutineContext")
            delay(1000)
            println("Job1: after suspend function. / $coroutineContext")
        }

        launch {
            // 부모의 문맥을 상속 (상위 launch 의 자식)
            // launch(Dispatchers.Default){ ... } // 부모의 문맥을 상속 (상위 launch의 자식), 부모 coroutine 취소 시 취소됨, 분리된 작업 (지연함수가 존재하는 경우 분리되서 처리)
            // CoroutineScope(Dispatchers.Default).launch { } // 새로운 scope가 구성되 request와 무관, 부모 coroutine 취소되더라도 task 수행에 영향을 받지 않음

            delay(100)
            println("Job2: before suspend function. / $coroutineContext")
            delay(1000)
            println("Job2: after suspend function. / $coroutineContext") // request(부모)가 취소되면 수행되지 않음
        }
    }

    delay(500)
    request.cancel() // 부모 coroutine 취소
    delay(1000)
}