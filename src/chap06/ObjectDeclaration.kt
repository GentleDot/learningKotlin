package chap06

object OCustomer {
    var name = "dooly"
    fun greeting() = println("Hello, world!")
    val HOBBY = Hobby("BasketBall")
    init {
        println("Init!!")
    }
}

class Hobby(val name: String)

fun main() {
    OCustomer.greeting()
    println(OCustomer.name)
    println(OCustomer.HOBBY.name)
}