package chap02

import kotlin.reflect.jvm.jvmName

fun main() {
//    getMinAndMax()
//    printExampleString()

    var str1: String? = "Hello, world."
    str1 = null

    println("str1 : ${str1}, length : ${str1?.length}")

    val len = str1?.length ?: -1
    println("str1 : ${str1}, length : ${len}")

    val a: Int = 128
    val b: Int = 128
    val c: Int? = a
    val d: Int = 127
    val e: Int? = d
    val f: Int? = d
    val g: Int? = a

    println(a == b)
    println(a === b)        // true
    println(a === c)        // false
    println(e === f)        // true
    println(c === g)        // false

    var test: Number = 12.2 // test는 Float Type
    println(test)
    println("$test")

    test = 12   // Int Type으로 Smart casting
    println(test)
    println("$test")

    test = 120L // Long Type으로 Smart casting
    println(test)
    println("$test")

    test += 12.0f   // Float Type으로 Smart casting
    println(test)
    println("$test")
    println(test.javaClass)
    println("${test.javaClass}")
    println("=======")
    println(test is Float)
    println(test.javaClass.name)
    println(test.javaClass.kotlin)
    println(test.javaClass.kotlin.simpleName)
    println(test.javaClass.kotlin.qualifiedName)
    println(test.javaClass.kotlin.jvmName)

    if (test is Float) {
        println("test는 Float")
    } else if (test !is Float) {
        println("test는 Float이 아님")
    }

    var anyVal: Any = 1
    anyVal = 20L
    println("anyVal : $anyVal  type : ${anyVal.javaClass}")

    checkArg("Hello, world.")
    checkArg(123)
    checkArg("123")

}

private fun checkArg(x: Any) {
    if (x is String){
        println("x 는 String : ${x}")
    } else if (x is Int){
        println("x 는 Int : ${x}")
    }
}

private fun printExampleString() {
    var a = 1
    val str1 = "a = $a"
    val str2 = "b = ${a + 2}"

    println("str1: \"$str1\", str2: \"$str2\"")
}

private fun getMinAndMax() {
    println("Byte min   : ${Byte.MIN_VALUE}     // max : ${Byte.MAX_VALUE}")
    println("Short min  : ${Short.MIN_VALUE}    // max : ${Short.MAX_VALUE}")
    println("Int min    : ${Int.MIN_VALUE}      // max : ${Int.MAX_VALUE}")
    println("Long min   : ${Long.MIN_VALUE}     // max : ${Long.MAX_VALUE}")
    println("Float min  : ${Float.MIN_VALUE}    // max : ${Float.MAX_VALUE}")
    println("Double min : ${Double.MIN_VALUE}   // max : ${Double.MAX_VALUE}")
}