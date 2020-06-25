import com.example.edu.Person

fun main() {
    println("Hello Cotlin!")

    val person = Person("gentledot", 20)

    println(person)
    println(person.age)
    println(person.name)

    val num: Int = 20

    println("name = ${person.name}, num = $num")

    val sixteen = 0x0F
    val digital = 0b00001011
    val ulong: ULong = 46_322_342u
    println(sixteen)
    println(digital)
    println(ulong)

    var doubleNum: Double = 0.1

    for (x in 0..999){
        doubleNum += 0.1
    }

    println(doubleNum)

}