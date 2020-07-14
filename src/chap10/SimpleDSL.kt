package chap10

data class Person(var name: String? = null, var age: Int? = null, var job: Job? = null)

data class Job(var category: String? = null, var position: String? = null, var extension: Int? = null)

/*fun person(block: (Person) -> Unit): Person {
    val p = Person()
    block(p)
    return p
}*/

/*fun person(block: Person.() -> Unit): Person {
    val p = Person()
    p.block()
    return p
}*/

fun person(block: Person.() -> Unit): Person = Person().apply(block)

fun Person.job(block: Job.() -> Unit) {
    job = Job().apply(block)
}

val newPerson = person {
    name = "MyName"
    age = 30
    job {
        category = "IT"
        position = "Web Developer"
        extension = 1234
    }
}

fun main() {
    println(newPerson)
}