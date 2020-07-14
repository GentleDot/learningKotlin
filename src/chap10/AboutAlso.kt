package chap10

import java.io.File

fun main() {
    var m = 1
    m = m.also { it + 3 }
    println(m)

    data class Person(var name: String, var skills: String)

    var person = Person("gentledot", "Kotlin")

    val a = person.let {
        it.skills = "Android"
        "success"
    }

    println(person)
    println("a : $a")

    val b = person.also {
        it.skills = "Java"
        "success"
    }

    println(person)
    println("b : $b")

    fun makeDir(path: String): File {
        val result = File(path)
        result.mkdir()
        return result
    }

    //    fun simpleMakeDir(path: String) = File(path).also { it.mkdir() }
    fun simpleMakeDir(path: String) = path.let { File(it) }.also { it.mkdir() }

}