package chap11

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
//    useChannel()
    val channel = Channel<Int>(3) // bufferCapacity = 3
    val sender = launch(coroutineContext) {
        repeat(10) {
            println("Sending $it")
            channel.send(it) // 지속적으로 보내고 buffer가 꽉 차면 일시 지연
        }
    }

    delay(1000)
    sender.cancel() // 송신자 작업 취소
}

private suspend fun CoroutineScope.useChannel() {
    val channel = Channel<Int>()
    launch {
        // 다량의 CPU 연산 작업 또는 비동기 로직 등...
        for (x in 1..5) channel.send(x * x)
        channel.close()
    }

    /*repeat(5) {
        println(channel.receive())
    }*/
    // channel 끝까지 읽기
    for (element in channel) println(element)

    println("Done!")
}