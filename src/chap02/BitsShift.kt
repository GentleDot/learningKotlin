package chap02

import chap03.getLongString

fun main() {
    val num = 4
    val negativeNum = -4

    println(num.shl(2))  // 0100 -> 0001 0000
    println(num shl 2)  // 중위 표현법(infix expression)
    println(negativeNum shl 2)  // 1 ... 0100 0000

    println(num shr 2)
    println(num ushr 2)
    println(negativeNum ushr 2) // 0010 ... 0000 0001

    var x = 4
    var y = 0b0000_1010     // 10
    var z = 0x0F    // 15

    print("x shl 2: ")
    println(x shl 2)
    print("x.inv(): ")
    println(x.inv())

    print("y shr 2 (=y / 4): ")
    println(y shr 2)
    print("x shl 4 (=x * 16): ")
    println(x shl 4)
    print("z shl 4 (=z * 16): ")
    println(z shl 4)

    x = 64
    print("x shr 4 (=x / 16): ")
    println(x shr 4)

    val number1 = 12 // 0b00001100
    val number2 = 25 // 0b00011001
    var result: Int

//    result = number1.or(number2)
    result = number1 or number2 // 0b00011101
    result = number1 xor number2 // 0b00010101
    println(result)
}