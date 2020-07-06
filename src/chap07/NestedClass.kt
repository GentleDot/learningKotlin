package chap07

class Outer {
    val ov = 5

    class Nested {
        val nv = 10
        fun greeting() = "[Nested] Hello! $nv" // 외부의 ov에는 접근 불가
    }

    inner class External{
        fun getSomething() = "$ov, and Something..." // 외부의 ov 접근 가능
    }

    fun outside() {
        val msg = Nested().greeting() // Outer 객체 생성 없이 중첩 클래스의 메서드 접근
        println("[Outer]: $msg, ${Nested().nv}") // 중첩 클래스의 프로퍼티 졉근
    }

    companion object {  // static처럼 접근 가능
        const val country = "Korea"
        fun getSomething() = println("Something...")
    }
}

fun main() {
    // static 처럼 Outer 객체 생성 없이 nested 객체를 생성 사용할 수 있음
    val output = Outer.Nested().greeting()
    println(output)

    // Outer.outside() // 에러! Outer 객체 생성 필요
    val outer = Outer()
    outer.outside()
}