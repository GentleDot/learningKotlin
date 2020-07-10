package chap08

import java.lang.StringBuilder

fun main() {
    val str = "hello"
    println(str.substring(0..2))

    var s = "from " + str.substring(0, 4)
    println(s)

    var s1 = "Hello Kotlin"
    var s2 = "Hello KOTLIN"

    println(s1.compareTo(s2)) // 32
    println(s1.compareTo(s2, true)) // 0

    s1.toLowerCase()
    s1.toUpperCase()
    val split = s1.split(" ")
    s1.trim()

    val uni = "\uAC00" // 한글 코드는 범위는 AC00 ~ D7AF
    println(uni) // 가

    var sb = StringBuilder("hello")
    sb[2] = 'x'
    println(sb) // hexlo

    sb.append("World")
    println(sb)

    sb.insert(10, "Yahoo!")
    println(sb)

    sb.delete(5, 10)
    println(sb)


    val text =
        """
            |Tell me and I forget.
            |Teach me and I remenber.
            |Involve me and I learn.
            |(Benjamin Franklin)
        """.trimMargin() // trim default는 |
    println(text)


    val pi = 3.1415926
    val dec = 10
    val str2 = "hello"

    println("pi = %.2f, %3d, %s".format(pi, dec, str2))
}