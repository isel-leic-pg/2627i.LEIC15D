
// No enunciado estava "pedir" mas faz mais sentido ser "recebe" portanto a soluçãpo considera "recebe"
fun countLetter(str: String, letter: Char): Int {
    var count = 0
    for (l in str) if (l == letter) count++
    return count
}
fun main() {
    println(countLetter("Batata",'t'))
    println(countLetter("Programacao",'g'))
    println(countLetter("Pontos",'e'))
}