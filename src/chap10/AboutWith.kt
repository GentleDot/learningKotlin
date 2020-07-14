package chap10

fun main() {
    data class User(val name: String, var skills: String, var email: String? = null)

    val user = User("gentledot", "Default")

    val result = with(user) {
        skills = "Kotlin"
        email = "gentledot@email.net"
    }

    println(user) // User(name=gentledot, skills=Kotlin, email=gentledot@email.net)
    println("result : $result") // result : kotlin.Unit
}