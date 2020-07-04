package chap07

interface A {
    fun functionA() {}
}

interface B {
    fun functionB() {}
}

class C(val a: A, val b: B) {
    fun functionC() {
        a.functionA()
        b.functionB()
    }

}

class DelegatedC(a: A, b: B) : A by a, B by b {
    fun functionC() {
        functionA()
        functionB()
    }
}


interface Nameable {
    var name: String
}

class StaffName : Nameable {
    override var name: String = "Sean"
}

class Work: Runnable { // thread 실행을 위한 interface
    override fun run() {
        println("work...")
    }
}

class Person(name: Nameable, work: Runnable): Nameable by name, Runnable by work

fun main() {
    val person = Person(StaffName(), Work()) // 생성자를 사용해 객체를 전달
    println(person.name) // 위임 된 name 인 StaffName class의 name 접근
    person.run() // 위임된 work인 Work class의 run 접근
}