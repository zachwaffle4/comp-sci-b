package playground

fun main() {
    val list = listOf(1,2,3,4,5,6,7,8,9,10)
    val list2 = list.map { addOne(it) }
}

fun addOne(i: Int): Int {
    return i + 1
}