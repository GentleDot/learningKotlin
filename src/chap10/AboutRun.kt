package chap10

fun main() {
    /*var skills = "Kotlin"
    println(skills) // Kotlin

    val a = 10
    skills = run {
        val level = "Kotlin Level: " + a
        level
    }

    println(skills) // Kotlin Level: 10*/

    data class Person(var name: String, var skills: String)

    var person = Person("gentledot", "Kotlin")

    val returnObj = person.apply {
        this.name = "Sean"
        skills = "Java"
        "success"
    }

    println(person)
    println("returnObj : $returnObj")

    val returnObj2 = person.run {
        this.name = "Dooly"
        this.skills = "Angular"
        "success"
    }

    println(person)
    println("returnObj2 : $returnObj2")
}