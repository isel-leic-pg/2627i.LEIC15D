fun main() {
    println("Indique a nota:")
    val nota = readln().toDouble()
    val estado = if (nota >= 9.5) "Aprovado" else "Reprovado"
    println("Nota $nota. O aluno está $estado!")


//    if (nota >= 9.5)
//        println("Aprovado!")
//    else println("Reprovado :(")
}
