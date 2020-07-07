package chap07

class Point(var x: Int = 0, var y: Int = 10) {
    // plus 함수의 연산자 오버로딩
    operator fun plus(p: Point): Point {
        return Point(x + p.x, y + p.y)
    }

    operator fun dec() = Point(--x, --y)
}

fun main() {
    val p1 = Point(3, -8)
    val p2 = Point(2, 9)
    var point = Point() // x = 0, y = 10
    println("point = (${point.x}, ${point.y})")

    point = p1 + p2 // Point 객체의 + 연산이 가능하게 됨
    println("point = (${point.x}, ${point.y})")

    --point
    println("point = (${point.x}, ${point.y})")
    val a = false
    a.not() // !a

    var b = 5
    b.unaryMinus()
    b.inc()

    val sum = { x: Int, y: Int -> x + y }
    sum.invoke(3, 10)
    sum(3, 10) // sum.invoke()로 함수가 호출되며, 기본적으로 생략됨

    val i = 1 // 포함 여부 판단시에는 정의된 변수가 필요
    if (i in 1..10) {
        println(i)
    }

    // 반복문에서는 j가 임시 변수로 사용
    for (j in 1..4) print(i) // "1""2""3""4" 출력
}