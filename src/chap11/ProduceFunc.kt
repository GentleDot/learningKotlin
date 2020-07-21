package chap11

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select
import java.util.*

fun CoroutineScope.producer(): ReceiveChannel<Int> = produce {
    var total = 0
    for (x in 1..5) {
        total += x
        send(total)
    }
}

fun main() = runBlocking {
    /*val result = producer() // 값 생산
    result.consumeEach { print("$it ") }*/

    val routine1 = GlobalScope.produce {
        delay(Random().nextInt(1000).toLong()) // java.util.Random
        send("A")
    }

    val routine2 = GlobalScope.produce {
        delay(Random().nextInt(1000).toLong()) // java.util.Random
        send("B")
    }

    val result = select<String> {
        // 둘 중 먼저 수행된 것을 받게 됨
        routine1.onReceive {s -> s}
        routine2.onReceive {result -> result}
    }

    println("Result was $result")
}