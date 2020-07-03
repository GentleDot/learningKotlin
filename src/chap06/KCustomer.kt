package chap06

class KCustomer {
    companion object {
        const val LEVEL = "INTERMEDIATE"    // const의 사용은 오직 String이나 원시 자료형에 해당하는 타입만 사용 가능
        @JvmStatic fun login() = println("Login Access!")
    }
}