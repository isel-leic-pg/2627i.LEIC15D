fun main() {
    val valor = readln().toInt()
    when {
        valor > 3 -> println("Maior que 3")
        valor >= 0 -> println("Positivo")
        else -> println("Negativo")
    }
}

