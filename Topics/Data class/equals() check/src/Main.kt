data class Client(val name: String, val age: Int, val balance: Int)

fun main() {
    //implement your code here
    val cl1 = Client(readLine().toString(), readLine()!!.toInt(), readLine()!!.toInt())
    val cl2 = Client(readLine().toString(), readLine()!!.toInt(), readLine()!!.toInt())
    println (cl1.name == cl2.name && cl1.age == cl2.age)
}