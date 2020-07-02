package chap06

import kotlin.properties.Delegates

class NameChangeableUser {
    var name: String by Delegates.observable("NONAME") { // property를 위임
            property, oldValue, newValue -> // parameter로는 property, 기존 값, 새로운 값
        println("$oldValue -> $newValue") // 이 부분은 이벤트가 발생할 때 (name 값이 변경될 때) 실행
    }
}

fun main() {
    val user = NameChangeableUser()
    println("user.name : ${user.name}")
    user.name = "Hani"
    println("user.name : ${user.name}")
    user.name = "Dooly"


    var max: Int by Delegates.vetoable(0) {
        property, oldValue, newValue ->
        newValue > oldValue // 새로운 값이 기존 값보다 크지 않으면 거부권 행사
    }

    println(max)
    max = 10
    println(max)

    max = 5
    println(max) // 10 (새로 할당하는 값이 기존 값보다 작으므로 재할당하지 않음)
}