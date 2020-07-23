package chap11

@Volatile // cache에서 사용하지 않음을 보장, 메모리 상에 값이 쓰이므로 즉각 반영
private var running = false
private var count = 0

fun start() {
    running = true
    thread(start = true) {
        while (running) {
            println("${Thread.currentThread()}, count: ${count++}")
        }
    }
}

fun stop() { running = false}

fun main() {
    start()
    start()
    Thread.sleep(10)
    stop() // running 상태 변경
}
