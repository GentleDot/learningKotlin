package chap06

import java.sql.PseudoColumnUsage

class LazyTest {
    init {
        println("init block")
    }

    val subject by lazy {
        println("lazy initialized")
        "Kotlin Programming"
    }

    fun flow() {
        println("not initialized")
        println("subject one : $subject")  // 최초 초기화 시점
        println("subject two : $subject")  // 초기화되어 할당된 값 사용
    }
}

class PersonByLazy(val name: String, val age : Int)

fun main() {
    val test = LazyTest()
    test.flow() // flow 내 subject 참조 사용 시 초기화

    var isPersonInstantiated: Boolean = false

    val person : PersonByLazy by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        isPersonInstantiated = true
        PersonByLazy("kim", 23)
    }

    val personDelegate = lazy { PersonByLazy("hong", 40) }

    println("person Init : $isPersonInstantiated")
    println("personDelegate Init : ${personDelegate.isInitialized()}")

    println("person.name = ${person.name}")
    println("personDelegate.value.name = ${personDelegate.value.name}")

    println("person Init : $isPersonInstantiated")
    println("personDelegate Init : ${personDelegate.isInitialized()}")
}