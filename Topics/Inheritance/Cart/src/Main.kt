fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = Product(productType, price)
    println(totalPrice(product))
}
fun totalPrice(product: Product): Any {
    when (product.productType) {
        "headphones" -> product.price += (product.price * 0.11).toInt()
        "smartphone" -> product.price += (product.price * 0.15).toInt()
        "tv" -> product.price += (product.price * 0.17).toInt()
        "laptop" -> product.price += (product.price * 0.19).toInt()
    }
    return product.price
}
class Product(val productType: String, var price: Int)