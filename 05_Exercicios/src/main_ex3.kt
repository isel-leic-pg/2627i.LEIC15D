
fun main() {
    val numero =1141
    val digito = 1
    var count = 0
    var auxNum = numero
    while (auxNum > 0) {
       if (auxNum % 10 == digito) count++
        auxNum /= 10
    }
    println(count)
    // Com strings
    count = 0
    val strNum = numero.toString()
    val cdig = '0'+digito
    for (d in strNum) if (d == cdig) count ++
    println (count)
}