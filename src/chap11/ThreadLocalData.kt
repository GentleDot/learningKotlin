package chap11

import kotlinx.coroutines.*

val threadLocal = ThreadLocal<String?>() // 스레드-지역 변수 선언
fun main() = runBlocking<Unit> {
    threadLocal.set("main")
    println("Pre-main: thread local value: '${threadLocal.get()}’") // main
    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) { // context 변경 -> launch
        println("Launch start: thread local value: '${threadLocal.get()}'") // launch
        yield()
        println("After yield: thread local value: '${threadLocal.get()}'") // launch
    }
    withContext(Dispatchers.Unconfined) {// context 변경
        println(threadLocal.get())
        threadLocal.set("UI")
    }
    job.join()
    println("Post-main: thread local value: '${threadLocal.get()}’") // main (Unconfined = UI)
}