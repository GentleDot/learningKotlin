package chap03

import java.util.concurrent.locks.ReentrantLock

var sharable = 1

fun main() {
    val relock = ReentrantLock()

    lock(relock, { criticalFunc() })
    lock(relock) { criticalFunc() }
    lock(relock, ::criticalFunc)

    println(sharable)

}


fun <T> lock(relock: ReentrantLock, body: () -> T): T {
    relock.lock()
    try {
        return body()
    } finally {
        relock.unlock()
    }
}

// 임계 영역
fun criticalFunc() {
    sharable += 1
}

fun networkCall(onSuccess: (String) -> Unit, onError: (Throwable) -> Unit) {
    try {
        onSuccess("success")
    } catch (e: Throwable) {
        onError(e)
    }
}
