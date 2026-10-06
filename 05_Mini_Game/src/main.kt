val celSize:Int = 3
val numCels:Int = 5


fun main() {
    printGrid()
}

fun printGrid() {
    separatorLine(celSize,numCels)
    println()
    for(x in 1..celSize) {
        for (y in 1..celSize) {
            cellLine(celSize,numCels)
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
    for (x in 1..numCels) {
        for (y in 1..celSize) print(" ")
        print(separator)
    }
}

