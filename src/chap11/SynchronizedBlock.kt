package chap11

var globalVariable = 20 // 공유 자원

@Synchronized fun synchronizedMethod() {
    globalVariable += 1
    println("${Thread.currentThread()} global = $globalVariable")
}

fun main() {
    synchronizedMethod()
}