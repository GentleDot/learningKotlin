package chap11

val fibonacciSeq = sequence {
    var a = 0
    var b = 1
    yield(1) // 지연 함수 사용해 출력

    while (true) {
        yield(a + b) // a + b 산출
        val temp = a + b
        a = b
        b = temp
    }
}

fun main() {
    println(fibonacciSeq.take(8).toList()) // take(8).toList() = 8번 실행된 값을 list로 획득
}