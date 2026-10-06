import java.util.Locale
import java.util.Locale.getDefault

val celSize:Int = 3
val numCels:Int = 5

var posx: Int = 1
var posy: Int = 1

fun main() {
    while (true) {
        printGrid()
        move()
    }
}

fun printGrid() {
    separatorLine(celSize,numCels)
    println()
    for(y in 1..numCels) {
        for (x in 1..celSize) {
            if (posy == y && x == (1+celSize/2)) playerLine(celSize,numCels)
            else cellLine(celSize,numCels)

            println()
        }
        separatorLine(celSize,numCels)
        println()
    }
}

fun separatorLine(celSize: Int, numCels: Int,  separator:Char = '#') {
    val numChars: Int = (celSize+1)*numCels+1
    for(x in 1..numChars) print(separator)
}

fun cellLine(celSize: Int, numCels: Int, separator:Char = '#') {
    print(separator)
    for (y in 1..numCels) {
        for (x in 1..celSize) print(" ")
        print(separator)
    }
}


fun playerLine(celSize: Int, numCels: Int, separator:Char = '#') {
    print(separator)
    for (x in 1..numCels) {
        for (y in 1..celSize) {
            if (posx == x && y == (celSize/2+1)) print("P")
            else print(" ")
        }
        print(separator)
    }
}

fun move() {
    println("Para onde mover (W,A,S,D):")
    val m: String = readln().uppercase(getDefault())
    when (m) {
        "W" -> if (posy>1) posy--
        "S" -> if (posy<numCels) posy++
        "A" -> if (posx>1) posx--
        "D" -> if (posx<numCels) posx++
        else Unit
    }

}