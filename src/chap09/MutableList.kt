package chap09

fun main() {
    val stringList: ArrayList<String> = arrayListOf("Hello", "Kotlin", "Wow")
    stringList.add("Java")
    stringList.remove("Hello")
    println(stringList)

    val mutableMixedList = mutableListOf("a", 2, "c", 4, 'g', 2.525)
    val mutableArr = mutableListOf("Android", "iOS", "Windows Mobile", "etc.")
    mutableArr.add("Ben")
    mutableArr.removeAt(2)
    mutableArr[0] = "Android 10" // set(0, "Android 10")과 같은 역할
    println(mutableArr)

    val names = listOf("a", "b", "C")
    val mutableNames = names.toMutableList()
    mutableNames.add("D")
    println(mutableNames)
}