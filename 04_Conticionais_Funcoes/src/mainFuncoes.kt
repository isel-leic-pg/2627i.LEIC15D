fun main() {
    println(joinTextToBinary(bin =23))
}

fun joinTextToBinary(text:String ="", bin: Int = 0) : String {
    return text+bin.toString(2)
}