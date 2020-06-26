package chap03


private fun sum(a: Int, b: Int): Int {
    return a + b
}

private fun sum2(a: Int, b: Int): Int = a + b

fun main() {
    println(sum(1, 2))
    addUser("gentledot")
    namedParam(x = 200, z = 100)
    handleVarargs(1, 2, 3, 4)

    val a = fun(x: Int, y: Int): Int = x + y
    val b = fun(x: Int, y: Int): Int {
        return x + y
    }
}

private fun addUser(name: String, email: String = "defaultEmail") {
    println("user = ${name}, email = $email")
}

private fun namedParam(x: Int = 100, y: Int = 200, z: Int) {
    println(x + y + z)
}

private fun handleVarargs(vararg counts: Int) {
    println(counts.javaClass)
    println(counts.javaClass.kotlin)
    println(counts.javaClass.kotlin.qualifiedName)
    for (num in counts) {
        println(num)
    }
    print("\n")
}
