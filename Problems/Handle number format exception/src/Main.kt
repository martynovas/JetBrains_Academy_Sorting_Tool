const val CARD_PATTERN = """^\d{4}\s\d{4}\s\d{4}\s\d{4}$"""

fun parseCardNumber(cardNumber: String): Long {
    if (!Regex(CARD_PATTERN).matches(cardNumber))
        throw IllegalArgumentException("Incorect card number")

    return cardNumber.replace(" ", "").toLong()
}