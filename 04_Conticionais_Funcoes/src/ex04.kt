fun main() {
    println("Por favor insira o primeiro valor:")
    val first = readln().toInt()
    println("Por favor insira o segundo valor:")
    val second = readln().toInt()
    println("Por favor insira o terceiro valor:")
    val third = readln().toInt()

    printOrdered(first,second,third)
}

fun printOrdered(first:Int, second:Int, third:Int) {
    if (first < second)
        if (second < third) println("$first $second $third")
        // o second é o maior de todos e os outros dois?
        else if (third < first) println("$third $first $second")
        else println("$first $third $second")
    else if (first < third) println("$second $first $third")
    // o first é o maior de todos e os outros dois?
        else if (third < second) println("$third $second $first")
        else println("$second $third $first ")
}