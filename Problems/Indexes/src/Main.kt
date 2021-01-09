fun solution(products: List<String>, product: String) {
    products.indices.filter { products[it] == product }.joinToString(" ").also { println(it) }
}