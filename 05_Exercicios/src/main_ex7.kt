

// Este problema é simples no caso geral mas tem alguma dificuldade a tratar os casos limite.
// 3 casos possíveis cada um com cálculos diferentes
// Quando temos zero alunos
// Quando todas as salas estão cheicas
// Quando não enchemos totalmente as salas

fun main() {
    println("Tamanho da sala")
    val tam = readln().toInt()
    println("Numero de alunos")
    val n = readln().toInt()
    val div = n/tam
    val rest = n%tam
    val numSalas = if (rest==0) div else div+1
    // A menos que todas as salas fiquem cheias precisamos de ter mais uma sala com o "resto" dos alunos
    println("São necessárias $numSalas salas")
    // Se todas as salas ficarem cheias a ultima sala estará cheia, senão fica com o "resto"
    println("Salas cheias: A ultima sala fica com ${if (n!= 0 && rest==0) tam else n%tam} alunos")
    println("Distribuídos: Cada sala terá ${if (n==0) 0 else n.toDouble() / numSalas} alunos")

}
