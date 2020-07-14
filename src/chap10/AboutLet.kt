package chap10

fun main() {
    val score: Int? = 32
//    var score = null

    // null 확인
    fun checkScore() {
        if (score != null) {
            println("Score : $score")
        }
    }

    // let을 사용해 null 검사를 제거
    fun checkScoreWithLet() {
        score?.let {
            println("Score : $it")
        }
//        val str = score.toString()
        val str = score.let {
            it.toString()
        }
        println(str)
    }

    checkScore()
    checkScoreWithLet()

    var firstName: String?
    var lastName: String = "NONAME"

    firstName = null

    // if 문을 사용
    if (firstName != null) {
        println("$firstName $lastName")
    } else {
        println(lastName)
    }

    // let을 사용한 경우
    firstName?.let { print("$it $lastName") } ?: print(lastName)
}