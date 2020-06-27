package chap03

var global = 10 // 전역 - 패키지의 모든 범위에 적용

fun main() {
    val local1 = 20
    val local2 = 21

    fun nestedFunc(){
        global += 1
        val local1 = 30 // name shadowed: local1
        println("nestedFunc local1: $local1")
        println("nDestedFunc local2: $local2")
        println("nestedFunc global: $global") // 11
    }

    nestedFunc()
    outsideFunc()
    println("main local1: $local1")
    println("main local2: $local2")
    println("main global: $global") // 12, 두 곳의 함수에서 영향을 받은 최종 결과가 출력
}

fun outsideFunc() {
    global += 1
    val outVal = "OUTSIDE!"
    println("outsideFunc global : $global") // 12
    println("outsideFunc outval : $outVal")
}
