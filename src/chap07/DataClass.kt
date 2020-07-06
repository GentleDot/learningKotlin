package chap07

data class Customer(var name: String, var email: String) {
    var job: String = "Job Seeker"

    constructor(name: String, email: String, _job: String) : this(name, email) {
        job = _job
    }

    init {
        println("init block...")
    }

}

fun main() {
    val cus1 = Customer("gdd", "gdd@email.com")
    val cus2 = Customer("gdd", "gdd@email.com")
    val cus3 = cus1.copy(name = "Alice")

    /*println(cus1 == cus2)
    println(cus1.equals(cus2))
    println("${cus1.hashCode()}, ${cus2.hashCode()}")
    println(cus1.toString())
    println(cus3.toString())*/

    val (name, email) = cus1
    println("name = $name, email = $email")

    val name2 = cus1.component1()
    val email2 = cus1.component2()
    println("name = $name2, email = $email2")

    val customers = listOf(cus1, cus2, cus3)

    for ((name3, email3) in customers){
        println("name = $name3, email = $email3")
    }

    val myLambda = {
        (lName, lEmail): Customer ->
        println(lName)
        println(lEmail)
    }

    myLambda(cus1)

    val (myName, myEmail) = myFunc()
}

fun myFunc(): Customer {
    return Customer("Dooly", "hoi@email.com")
}