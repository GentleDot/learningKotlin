package chap06

class Person {
    lateinit var name: String

    fun test() {
        if (!::name.isInitialized){
            println("not Initialized")
        } else {
            println("Initialized")
        }
    }
}

fun main() {
    val gentledot = Person()
    gentledot.test()
    gentledot.name = "NONAME"
    gentledot.test()
    println("name : ${gentledot.name}")
}