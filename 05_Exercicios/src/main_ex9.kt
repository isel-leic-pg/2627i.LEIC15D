val g = 9.8
fun main() {
    println("Insira uma velocidade inicial:")
    val v = readln().toDouble()
    val hMax = v*v/(2*g)
    println("A altura máxima de uma bola lançada à velocidade de $v é de $hMax")
  }
