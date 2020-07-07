package chap08

class Box<T>(t: T) {
    var name = t
}

fun main() {
//    val box1 = Box(1) // 1이 Int 형이므로 Box<Int>로 유추
    val box1 : Box<Int> = Box<Int>(1)
//    val box2 : Box<String> = Box<String>("Hello")
    val box2 : Box<String> = Box("Hello") // "Hello"는 String이므로 Box<String>로 유추

    println(box1.name)
    println(box2.name)
    println(box1.javaClass) // class chap08.Box
}