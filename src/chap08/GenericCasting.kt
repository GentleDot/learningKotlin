package chap08

open class Parent

class Child: Parent()

class Cup<T>

fun main() {
    val objl: Parent = Child() // Parent 형식의 obj1은 child로 형 변환될 수 있음
    /*val obj2: Child = Parent() // 에러! 하위 형식인 Child는 Parent로 변환되지 않음
    val obj3: Cup<Parent> = Cup<Child>() // 에러! 자료형 형식이 일치하지 않음
    val obj4: Cup<Child> = Cup<Parent>() // 에러! 자료형 형식이 일치하지 않음*/
    val obj5 = Cup<Child>() // Cup<Child> 형식이 됨
    val obj6: Cup<Child> = obj5 // 형식이 일치
}