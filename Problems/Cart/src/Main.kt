import java.lang.IllegalArgumentException

fun main() {
    val productType = readLine()!!
    val price = readLine()!!
    val product = Product.getProduct(productType,price.toInt())
    println(product.totalPrice())
}

open class Product(val price: Int){
    companion object{
        fun getProduct(name: String, price: Int):Product =
                when(name) {
                    "headphones" -> Headphones(price)
                    "smartphone" -> Smartphone(price)
                    "tv"    -> TV(price)
                    "laptop"    -> Laptop(price)
                    else -> throw IllegalArgumentException()
                }
    }

    open val tax = 0

    fun totalPrice() = price + price * tax / 100
}

class Headphones(price: Int):Product(price){
    override val tax = 11
}

class Smartphone(price: Int):Product(price){
    override val tax = 15
}

class TV(price: Int):Product(price){
    override val tax = 17
}

class Laptop(price: Int):Product(price){
    override val tax = 19
}