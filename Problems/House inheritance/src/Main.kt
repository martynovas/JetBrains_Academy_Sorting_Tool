fun main() {
    val rooms = readLine()!!
    val price = readLine()!!
    val house = House.getHouse(rooms.toInt(), price.toInt())
    println(house.totalPrice().toInt())
}

open class House(val rooms: Int, val price: Int, val coefficient: Double) {
    companion object {
        fun getHouse(rooms: Int, price: Int): House =
                when (rooms) {
                    in Int.MIN_VALUE..1 -> Cabin(rooms, price.coerceIn(0, 1_000_000))
                    2, 3 -> Bungalow(rooms, price.coerceIn(0, 1_000_000))
                    4 -> Cottage(rooms, price.coerceIn(0, 1_000_000))
                    5, 7 -> Mansion(rooms, price.coerceIn(0, 1_000_000))
                    else -> Palace(rooms, price.coerceIn(0, 1_000_000))
                }
    }

    fun totalPrice() = price * coefficient
}

class Cabin(rooms: Int, price: Int) : House(rooms, price, 1.0)
class Bungalow(rooms: Int, price: Int) : House(rooms, price, 1.2)
class Cottage(rooms: Int, price: Int) : House(rooms, price, 1.25)
class Mansion(rooms: Int, price: Int) : House(rooms, price, 1.4)
class Palace(rooms: Int, price: Int) : House(rooms, price, 1.6)
