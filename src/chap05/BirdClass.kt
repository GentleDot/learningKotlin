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

class AnotherBird {
    var name: String
    var wing: Int
    var beak: String
    var color: String

    constructor(name: String, wing: Int, beak: String, color: String) {
        this.name = name
        this.wing = wing
        this.beak = beak
        this.color = color
    }

    init {
        println("====== 초기화 블록 시작 ======")
        println("이름과 색상 확인 : 이름 = $name, 색상 = $color")
        println("====== 초기화 블록 종료 ======")
    }

    fun fly() = println("Fly Wing : $wing")
    fun sing(vol: Int) = println("Sing Volume : $vol")
    fun getColor() = println("Color is : $color")
}


fun main() {
//    val coco = Bird();
    val coco = AnotherBird("myBird", 2, "short", "blue")
    /*
    coco.color = "red"
    println("coco의 색상은 : ${coco.color}")
    coco.fly()
    coco.sing(3)
    */
}