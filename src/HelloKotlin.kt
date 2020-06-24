import com.example.edu.Person

fun main(){
    println("Hello Cotlin!")

    val person = Person("gentledot", 20)

    println(person)
    println(person.age)
    println(person.name)

    val num: Int = 20

    println("name = ${person.name}, num = $num")
}