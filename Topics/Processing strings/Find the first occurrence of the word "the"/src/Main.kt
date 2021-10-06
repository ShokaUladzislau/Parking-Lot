fun main() {
    // write your code here
    val str = readLine()

    if (str?.contains(Regex("The")) == true) {
        println(str.indexOf("The"))
    } else if (str?.contains(Regex("the")) == true) {
        println(str.indexOf("the"))
    } else {
        println("-1")
    }
}