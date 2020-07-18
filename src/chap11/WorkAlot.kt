package chap11

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun work(i: Int) {
    Thread.sleep(1000)
    println("Work $i Done!")
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        /*runBlocking {
            for (i in 1..2) {
                launch {
                    work(i)
                }
            }
        }*/

        /*runBlocking {
            for (i in 1..2) {
                launch(Dispatchers.Default){
                    work(i)
                }
            }
        }*/

        runBlocking {
            for (i in 1..2){
                GlobalScope.launch {
                    work(i)
                }
            }
        }

    }
    println("Done in $time ms")

    //    printDot()
    //    printSharp()
}

private suspend fun CoroutineScope.printDot() {
    val jobs = List(100_000) {
        launch(Dispatchers.Default) {
            delay(1000L)
            print(".")
        }
    }

    jobs.forEach {
        it.join()
    }
}

private suspend fun printSharp() {
    repeat(100_000) {
        delay(1000L)
        print("#")
    }
}