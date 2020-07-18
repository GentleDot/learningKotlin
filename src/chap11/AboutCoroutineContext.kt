package chap11

import kotlinx.coroutines.*
import java.util.concurrent.Executors

fun main() {
    // coroutineName 설정
    val myCoroutineName = CoroutineName("someCoroutineName")

    val parentJob = SupervisorJob() // 부모, 다른 자식에 전파되지 않기 때문에 취소가 일어나도 다른 작업에 영향을 주지 않음
    val someJob = Job(parentJob)

    // CoroutineDispatcher
    val MyPool = Executors.newFixedThreadPool(2).asCoroutineDispatcher()

    val someExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        val coroutineName = coroutineContext[CoroutineName]?.name ?: "DefaultName"
        println("Error in $coroutineName: ${throwable.localizedMessage}")
    }

    // GlobalScope 상에서 launch, async 사용은 권장하지 않음!!
    /*val scope1 = GlobalScope
    scope1.launch {
        // ...
    }
    scope1.async {
        // ...
    }*/

    val job1 = GlobalScope.launch {  } // Job 객체 -> Job.join()으로 기다림
    val job2 = GlobalScope.async {  } // Deferred 객체 -> Deferred.await()으로 기다림

    val scope2 = CoroutineScope(Dispatchers.Default)
    val routine1 = scope2.launch {  }
    val routine2 = scope2.async {  }

}

fun tempRun() = runBlocking {
    launch(Dispatchers.Default) {  }
    async(Dispatchers.Default) {  }
}