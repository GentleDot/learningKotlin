package chap07

interface Bird {
    var wings: Int
    fun fly()
    fun jump() = println("bird can jump!")
}

interface Horse {
    val maxSpeed: Int
    fun run()
    fun jump() = println("Jump! with max speed ($maxSpeed)")
}

class Pegasus : Bird, Horse {
    override var wings: Int = 2
    override val maxSpeed: Int = 100

    override fun fly() = println("fly!")
    override fun run() = println("Run!")
    override fun jump() {
        super<Horse>.jump()
        println("and Jump!")
    }
}