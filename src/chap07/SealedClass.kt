package chap07

sealed class Result {
    open class Success(val message: String) : Result()
    class Error(val code: Int, val message: String) : Result()
}

//sealed class Result

//open class Success(val message: String) : Result()
//class Error(val code: Int, val message: String): Result()

class Status : Result() // sealed class는 같은 파일에서만 사용 가능

//class Inside : Success("Process Success!")
class Inside : Result.Success("Process Success!") // 내부 클래스 상속

fun main() {
    val result = Result.Success("Good!")
    val result2 = Result.Error(404, "Page Not Found.")
    val msg = eval(result)
    val msg2 = eval(result2)
    println(msg)
    println(msg2)
}

fun eval(result: Result): String = when (result) {
    is Status -> "in progress"
    is Result.Success -> result.message
    is Result.Error -> "errorCode : ${result.code} / message : ${result.message}"
}
