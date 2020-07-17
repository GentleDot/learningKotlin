package chap11

// Thread class를 상속받아 구현
class SimpleThread : Thread() {
    override fun run() {
        println("Current Threads : ${currentThread()}")
    }
}

// Runnable interface로부터 구현
class SimpleRunnable : Runnable {
    override fun run() {
        println("Current Threads : ${Thread.currentThread()}")
    }

}

fun main() {
    val thread = SimpleThread()
    thread.start()

    val runnable = SimpleRunnable()
    val thread1 = Thread(runnable)
    thread1.start()

    // 익명 객체를 사용하면 class의 객체를 만들지 않고 실행 가능
    object : Thread() {
        override fun run() {
            println("Current Threads(object) : ${currentThread()}")
        }
    }.start()
}