package chap05

class Bird {
    var name: String = "myBird"
    var wing: Int = 2
    var beak: String = "short"
    var color: String = "blue"

    fun fly() = println("Fly Wing : $wing")
    fun sing(vol: Int) = println("Sing Volume : $vol")
    fun getColor() = println("Color is : $color")
}

fun main() {
    val coco = Bird();
    coco.color = "red"

    println("coco의 색상은 : ${coco.color}")
    coco.fly()
    coco.sing(3)
}