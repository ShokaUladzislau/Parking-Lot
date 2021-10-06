fun main() = print(readLine()!!
    .toList()
    .map { it.toInt() }
    .chunked(3)
    .map { it.sum() }
    .let { if (it[0] == it[1]) "Lucky" else "Regular" })
