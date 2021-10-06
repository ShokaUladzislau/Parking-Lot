fun main() {
    val word = readLine()!!
    val reverseWord = word.reversed()
    if (word == reverseWord) println("yes") else println("no")
}

