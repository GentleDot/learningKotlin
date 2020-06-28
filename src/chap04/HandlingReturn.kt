package chap04

fun main() {
    retFunc()
    labelBreak()
    labelContinue()
}

// inline 키워드가 없다면 return 단독 사용 불가, 라벨 리턴 사용 가능
fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) = out(a, b)

fun retFunc() {
    println("retFunc 실행")
    /*
    inlineLambda(13, 3) lit@{a, b -> // @lit 으로 람다식에 라벨 설정
        val result = a + b
        if(result > 10) return@lit // @lit 라벨의 블록 끝으로 반환
        println("result: $result")
    }
    */

    /*
    inlineLambda(13, 3) { a, b -> // @lit 으로 람다식에 라벨 설정
        val result = a + b
        if (result > 10) return@inlineLambda // 암묵적라벨 (function 블록의 끝으로 이동)
        println("result: $result")
    }
    */

    inlineLambda(13, 3, fun(a, b) {
        val result = a + b
        if (result > 10) return
        println("result: $result")
    })
    println("retFunc 종료")
}

fun labelBreak() {
    println("라벨을 사용한 break")
    /*
    first@ for (i in 1..5) {
        second@ for (j in 1 until 5){
            if (j == 3) break // loop 중단, one depth의 for문으로 돌아감
            println("i : $i, j : $j")
        }
        println("after for j")
    }
    println("after for i")
    */

    first@ for (i in 1..5) {
        second@ for (j in 1 until 5){
            if (j == 3) break@first // loop 중단, one depth의 for문 끝으로 돌아감
            println("i : $i, j : $j")
        }
        println("after for j")
    }
    println("after for i")

}

fun labelContinue() {
    println("라벨을 사용한 continue")
    /*
    first@ for (i in 1..5) {
        second@ for (j in 1..5){
            if (j == 3) continue
            println("i : $i, j : $j")
        }
        println("after for j")
    }
    println("after for i")
    */
    first@ for (i in 1..5) {
        second@ for (j in 1..5){
            if (j == 3) continue@first
            println("i : $i, j : $j")
        }
        println("after for j")
    }
    println("after for i")
}