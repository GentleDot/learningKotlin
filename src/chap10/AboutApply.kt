package chap10

import java.io.File

fun main() {
    data class Person(var name: String, var skills: String)
    var person = Person("gentledot", "Kotlin")

    person.apply { this.skills = "Swift" }
    println(person)

    val returnObj = person.apply {
        // this를 생략하고 객체 멤버에 여러번 접근 가능
        name = "Sean"
        skills = "Java"
        skills = "JavaScript"
    }

    println(person)
    println(returnObj)

    fun makeDir(path: String): File {
        val result = File(path)
        result.mkdir()
        return result
    }

    val path = "PATH"
    File(path).apply {
        mkdirs()
    }
}