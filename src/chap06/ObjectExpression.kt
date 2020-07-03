package chap06

open class Superman() {
    fun work() = println("working in Press")
    fun talk() = println("talking with people")
    open fun fly() = println("flying in the air")
}

fun main() {
    val costumeSuperman = object : Superman() { // costumeSuperman 접근 시점에 재정의됨
        override fun fly() = println("I can't fly!")
    }
    costumeSuperman.work()
    costumeSuperman.talk()
    costumeSuperman.fly()
}