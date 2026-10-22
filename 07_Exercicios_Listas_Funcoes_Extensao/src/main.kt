
fun String.countLetters(letters:String): List<Int> {
    var list: List<Int> = listOf()
    for (l in letters) {
        var count = 0
        // this é a string à qual aplicámos a função extensão
        for (c in this) {
           if (l == c) count++
       }
        list += count
    }
    return list
}

fun String.countLetters1(letters:String): List<Int> =
    // this é a string à qual aplicámos a função extensão
    // O it representa cada letra do this dentro do count
    // O "l->" é necessário senão dentro do count teriamos
    // it == it que não funciona (só um it está "visivél")
    letters.map{ l ->this.count{ l == it }}
    // Se não soubermos do count podemos utilizar o filter
    //letters.map{ l ->this.filter{ l == it }.length}

fun String.countLetters2(letters:String): List<Int> =
    List(letters.length){ pos ->this.count{ letters[pos] == it }}

fun String.countLetters3(letters:String): List<Int> {
    // Tenho de criar o list porque no buildList já temos um this, que é a lista mutável
    val list = this
    return buildList {
        // O this neste caso corresponde à lista mutável
        // Não precisamos de fazer this.add(...) basta fazer add(...) que o add já é aplicado ao this (à lista mutável)
        for (l in letters) this.add(list.count{l == it})
    }
}

fun List<Int>.subtract(sub: List<Int>): List<Int> {
    var list:List<Int> = listOf()
    for (num in this) {
        if (num !in sub) list += num
        // Se não soubessemos do !in (mas deviamos saber :D )
        //var exists = false
        //for (n in sub) {
        //    if (n == num) exists = true
        //}
        //if (!exists) list += num
    }
    return list
}

fun List<Int>.subtract2(sub: List<Int>): List<Int> =
    this.filter{ it !in sub }

fun main() {
    println("banana".countLetters("bae"))
    println("banana".countLetters1("bae"))
    println("banana".countLetters2("bae"))
    println("banana".countLetters3("bae"))
    println(listOf(1,2,3,4).subtract(listOf(2,5,4)))
    println(listOf(1,2,3,4).subtract2(listOf(2,5,4)))
}
