// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    // implement your code here
    val height = readLine()!!.toInt()
    val length1 = readLine()!!.toInt()
    val length2 = readLine()!!.toInt()
    val width = readLine()!!.toInt()

    val b1 = Box(height, length1, width)
    val b2 = b1.copy(length = length2)

    println(b1.toString())
    println(b2.toString())
}