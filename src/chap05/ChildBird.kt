package chap05

open class ParentBird(var name: String, var wing: Int, var beak: String, var color: String) {

    init {
        println("ParentBird 초기화!")
    }

    fun fly() = println("Fly Wing : $wing")
    open fun sing(vol: Int) = println("Sing vol : $vol")
}

class Lark(name: String, wing: Int, beak: String, color: String) : ParentBird(name, wing, beak, color) {
    init {
        println("Lark 초기화!")
    }

    fun sayHello() = println("Hello! Hello!")
//    fun fly() = "Fly Faster!" // overriding 불가능
    override fun sing(vol: Int) {
//        super.sing(vol)
        println("Sing vol : ${vol * 2}")
    }
}

class Parrot : ParentBird {
    init {
        println("Parrot 초기화!")
    }

    val language: String

    constructor(name: String, wing: Int, beak: String, color: String, language: String) : super(
        name,
        wing,
        beak,
        color
    ) {
        this.language = language
    }

    fun speak() = println("can speak $language")
}

fun main() {
    val coco = ParentBird("mybird", 2, "short", "blue")
    val lark = Lark("mylark", 2, "long", "brown")
    val parrot = Parrot("myparrot", 2, "short", "multiple", "korean") // 프로퍼티가 추가됨
    println("Coco: ${coco.name}, ${coco.wing}, ${coco.beak}, ${coco.color}")
    println("Lark: ${lark.name}, ${lark.wing}, ${lark.beak}, ${lark.color}")
    println("Parrot: ${parrot.name}, ${parrot.wing}, ${parrot.beak}, ${parrot.color}, ${parrot.language}")
    lark.sayHello() // 새로 추가된 메서드가 사용 가능
    parrot.speak()
    lark.fly()
}