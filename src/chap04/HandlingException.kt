package chap04

fun main() {
    temp()
}

fun temp() {
    throw RuntimeException("non-check exception")
    throw InvalidNameException("사용자 예외 정의") // 앞의 예외처리로 인해 실행 안됨
}

class InvalidNameException(message: String) : RuntimeException(message)