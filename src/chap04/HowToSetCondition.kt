package chap04

fun tmp() {
    val a = readLine()?.toInt()
    if (a == null) {
        println("null")
        return
    }

    if (a == 1) {
        println("HI!")
    } else if (a == 2) {
        println("Hello!")
    } else if (a in 10..19) { // 10 ~ 19 사이 값이면 true
        println("다른 인삿말은 준비 중입니다.")
    } else {
        println("안녕하세요.")
    }
}

fun tmp2() {
    val a = readLine()?.toInt()
    if (a == null) {
        println("null")
        return
    }

    when (a) {
        1 -> {
            println("HI!")
        }
        2 -> {
            println("Hello!")
        }
        3, 4 -> println("Nice!")
        in 10..19 -> { // 10 ~ 19 사이 값이면 true
            println("다른 인삿말은 준비 중입니다.")
        }
        else -> {
            println("안녕하세요.")
        }
    }
}
