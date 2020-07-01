package chap06

import java.lang.AssertionError


class User(_id: Int, _name: String, _age: Int) {
    // properties
    val id: Int = _id
        get() = field

    private var tempName: String? = null

    var name: String = _name
//        get() = field
        get() {
            if (tempName == null) tempName = "NONAME"
            return tempName ?: throw AssertionError("Asserted by others")
        }
        set(value) {
            field = value
        }

    var age: Int = _age
        get() = field
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "User{id = $id, name = $name, age = $age}"
    }

}

fun main() {
    val user1 = User(1, "gentledot", 33)
//    user1.id = 2
    user1.age = 32
    println("user1 = $user1")

}