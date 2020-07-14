package chap10

fun main() {
    var string: String? = "hello"
    string = null
    if (string != null) {
        println(string.length)
    }

    val string2: String? = "hello"
//    string2 = null
    println(string2)
}