package chap09

fun main() {
    // seed 값 1로 설정하고 +1씩 증가하는 sequence 정의
    val nums = generateSequence(1, { it + 1 })
    // seed 값 2로 설정하고 +1씩 증가하는 sequence 정의
    val nums2 = generateSequence(2, { it + 1 })

    /*
        take()를 사용해 원하는 요소 개수만큼 획득
        toList()를 사용해 List collection 반환
    */
    println(nums.take(10).toList()) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    println(nums2.take(10).toList()) // [2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

    val squares = generateSequence(1) { it + 1 }.map { it * it }
    println(squares.take(10).toList()) // [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
    println(squares.filter { it % 2 != 0 }.take(5).toList()) // [1, 9, 25, 49, 81]

    val list1 = listOf(1, 2, 3, 4, 5)
    val listSeq = list1.asSequence()
        .map { println("map($it) "); it * it }
        .filter {
            println("filter($it) ")
            it % 2 == 0
        }
        .toList()

    println(listSeq)
}