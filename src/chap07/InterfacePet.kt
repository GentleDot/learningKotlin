package chap07

interface Pet {
    var category: String  // 추상 property
    val msgTags: String // val 선언 시 getter 구현 가능
        get() = "I'm your pet!"

    fun feeding()   //  추상 method
    fun patting() { // 일반 method
        println("keep patting")
    }
}

class Cat(override var category: String) : Pet {
    override fun feeding() {
        println("Feed the cat a Churu~")
    }
}