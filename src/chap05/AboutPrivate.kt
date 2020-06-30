package chap05

private class PrivateClass {
    private var i = 1
    private fun privateFunc() {
        i += 1 // 블록 내 접근 허용
    }
    fun access() {
        privateFunc() // 블록 내 접근 허용
    }
}
class OtherClass {
    //val opc = PrivateClass() // 불가 - 프로퍼티 opc가 private가 아님
    fun test() {
        val pc = PrivateClass() // 같은 파일 내에서 접근 가능하므로 생성 가능
    }
}
fun main() {
    val pc = PrivateClass() // 같은 파일 내에서 접근 가능하므로  생성 가능
    //pc.i // 접근 물가
    //pc.privateFunc() // 접근 불가
    pc.access() // 접근 가능
}
fun TopFunction() {
    val tpc = PrivateClass() // 같은 파일 내에서 접근 가능하므로  객체 생성 가능
}