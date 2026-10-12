
fun repete(str: String,n:Int) {
    for (i in 1..n) println(str)
}

fun main() {
    println("Insira a palavra:")
    val palavra = readln()
    println("Insira o número de vezes que quer repetir a palavra:")
    val n = readln().toInt()
   repete(palavra, n)
}
