package chap08

class InOutTest<in T, out U>(t: T, u: U) {
//    val propT: T = t // 오류! T는 in 위치이기 때문에 parameter 읽어들임 불가
    val propU: U = u // U는 out 위치이기 때문에 가능

//    fun func1(u: U) // 오류! U는 out 위치기 때문에 in 위치 (parameter로 set 하는 위치)에 사용 불가
    fun func2(t: T) { // T는 in 위치에 사용됨
        print(t)
    }
}

fun starTestFunc(v: InOutTest<*, *>) {
//    v.func2(1) // Nothing으로 parameter를 처리함
    println(v.propU)
}