package chap06

class PersonWithCompanion {
    var id: Int = 0;
    var name: String = "gentledot"

    companion object {
        var language: String = "Korean"
        fun work() {
            println("working...")
        }
    }
}

fun main() {
    println(PersonWithCompanion.language) // 인스턴스 생성 없이 기본값 사용
    PersonWithCompanion.language = "English" // 기본값 변경 가능
    println(PersonWithCompanion.language)
    PersonWithCompanion.work() // Method 실행
    // PersonWithCompanion.name <- companion object가 아니기 때문에 인스턴스 없이는 참조 불가

    println(Customer.LEVEL)
    Customer.login()
}