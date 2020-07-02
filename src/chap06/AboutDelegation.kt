package chap06

interface Car {
    fun go(): String
}

class VanImpl(val power: String) : Car {
    override fun go() = "는 짐을 적재, $power 마력을 가집니다."
}

class SportImpl(val power: String) : Car {
    override fun go() = "는 경주용에 최적화, $power 마력을 가집니다."
}

class CarModel(val model: String, impl: Car) : Car by impl { // impl 키워드로 구현 객체를 parameter로
    fun carInfo(){
        println("$model ${go()}") // 참조 없이 각 interface 구현 클래스의 go를 접근
    }
}

fun main() {
    val myDamas = CarModel("Damas 2020", VanImpl("100"))
    val mySuperCar = CarModel("Ferrari 812 GTS", SportImpl("800"))

    myDamas.carInfo()  // carInfo는 각 구현체의 go()를 출력
    mySuperCar.carInfo()    // carInfo는 각 구현체의 go()를 출력
}