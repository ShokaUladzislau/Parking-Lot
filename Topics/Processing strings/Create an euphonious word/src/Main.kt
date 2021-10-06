fun main() {
    val word = readLine().toString()
    var count = 0
    var currentTypeCount = 0
    var lastTypeVowel = true
    for (c in word) {
        if (isVowel(c) == lastTypeVowel) {
            if (++currentTypeCount == 3) {
                count++
                currentTypeCount = 1
            }
        } else {
            lastTypeVowel = !lastTypeVowel
            currentTypeCount = 1
        }
    }
    println(count)
}

fun isVowel(c: Char): Boolean {
    val vowels = listOf('a', 'e', 'i', 'o', 'u', 'y')
    return c in vowels
}