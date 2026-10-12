// Há soluções mais eficientes mas mais complexas
// https://en.wikipedia.org/wiki/String-searching_algorithm
fun subStr (txt:String,word:String ): Int {
    for (i in 0..(txt.length-word.length))
        if (txt[i] == word[0]) {
            var found = true
            for (j in 1..<word.length)
                if (txt[i + j] != word[j]) found = false
            if (found) return i
        }
    return -1
}
fun main() {
    val txt = "como o macaco gosta de banana eu gosto de ti"
    val word = "banana"
    println(subStr(txt, word))
    // A função já existe no Kotlin (mas convém saberem como se faz :D )
    println(txt.indexOf("banana"))
    // Qual o algoritmo utilizado pelo indexOf ? :D
}

