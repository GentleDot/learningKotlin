package chap08

open class Animal(val size: Int) {
    fun feed() = println("Feeding...")
}

class Cat(val jump: Int) : Animal(50)

class Spider(val poison: Boolean) : Animal(1)

class Storage<out T : Animal>(val element: T) { // 주 생성자에서 val만 허용
    fun getAnimal(): T = element // out은 반환 자료형에만 사용 가능
    /*fun set(new: T){
        element = new
    }*/ // T는 in 위치에 사용할 수 없으므로 오류!
}

fun main() {
    // 일반적인 객체 선언
    val c1: Cat = Cat(10)
    val s1: Spider = Spider(true)

    // 클래스의 상위 자료형 변환은 아무런 문제 없음
    var a1: Animal = c1
    a1 = s1 // a1이 Spider 객체 s1이 됨
    println("a1.size = ${a1.size}")

    // covariance (공변성) -> Cat은 Animal의 하위 자료형
    val c2: Storage<Animal> = Storage<Cat>(Cat(10))
    println("c2.element.size = ${c2.element.size}")

    // 반대의 경우 (contranvariance)는 가능하지 않음
//    val c3: Box<Cat> = Box<Animal>(10) // 오류!
    // 자료형이 제한되어 있어 Animal 하위 클래스 이외에는 사용할 수 없음
//    val c4: Box<Any> = Box<Int>(10) // 오류!
}

class TestBox<T>(var item: T)

fun <T> printObj(box: TestBox<out Animal>) {
    val obj: Animal = box.item // box.item 값을 얻음 (get)
//    box.item = Animal(1) // in이 설정되어 있지 않으므로 set 불가
    println(obj)
}