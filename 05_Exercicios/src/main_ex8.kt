
// Decidimos converter os intervalos para intervalos de reais
// Outra hipotese seria ter arredondado o número e trabalhado com inteiros
// O enunciado não estava claro, o valor da nota é Real mas os intervalos estão em inteiros
fun converte(nota:Double) =
    when (nota) {
        in 17.0..20.0 -> 'A'
        in 15.0 ..< 17.0 -> 'B'
        in 13.0 ..< 15.0 -> 'C'
        in 11.0 ..< 13.0 -> 'D'
        in 10.0 ..< 11.0 -> 'E'
        else -> 'F'
    }

fun main() {
    println("Insira uma nota entre 0.0 e 20.0")
    val nota = readln().toDouble()
    println("A nota $nota corresponde à avaliação de ${converte(nota)}")
  }
