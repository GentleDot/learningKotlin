package chap09

fun main() {
    // 가변형 Set 정의
    val animals = mutableSetOf("Lion", "Dog", "Python", "Cat", "Hippo")
    println(animals)

    // 요소 추가
    animals.add("Dog")
    println(animals) // 이미 존재하는 값이므로 변화 없음

    // 요소 삭제
    animals.remove("Python")
    println(animals)

    val intsHashSet = hashSetOf(6, 3, 4, 7)
    val stringHashSet = hashSetOf("basket", "almond", "ultra", "cap")
    println(intsHashSet)
    println(stringHashSet)
    intsHashSet.add(5) // 추가
    intsHashSet.remove(6) // 삭제
    println(intsHashSet)


    val intsSortedSet = sortedSetOf(4, 1, 7, 2)
    println(intsSortedSet)

    intsSortedSet.add(6)
    intsSortedSet.remove(1)
    println(intsSortedSet)
    intsSortedSet.clear()
    println(intsSortedSet)

    val intsLinkedHashSet = linkedSetOf(12, 6, 2)
    println(intsLinkedHashSet)

    intsLinkedHashSet.add(10)
    intsLinkedHashSet.add(12)
    intsLinkedHashSet.remove(6)
    println(intsLinkedHashSet)
}