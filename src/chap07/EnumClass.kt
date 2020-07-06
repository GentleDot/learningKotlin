package chap07

interface Score {
    fun getScore(): Int
}

enum class MemberType(var priority: String) : Score {
    NORMAL("third") {
        override fun getScore(): Int = 100
    },
    SILVER("second") {
        override fun getScore(): Int = 500
    },
    GOLD("first") {
        override fun getScore(): Int = 1500
    };  // enum member 선언 끝을 설정하는 세미콜론 (Error:(16, 6) Kotlin: Expecting ';' after the last enum entry or '}' to close enum class body)

    fun getPriority() = println("this is ${priority}")
}

fun main() {
    println(MemberType.NORMAL.getScore())
    println(MemberType.SILVER.priority)
    println(MemberType.valueOf("GOLD"))
    MemberType.GOLD.getPriority()

    for (grade in MemberType.values()) {
        println("grade.name = ${grade.name}, priority = ${grade.priority}")
    }
}