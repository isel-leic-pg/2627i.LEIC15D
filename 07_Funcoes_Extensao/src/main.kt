
fun List<Int>.myFilter(f: (Int) -> Boolean): List<Int> {
    var list:List<Int> = listOf()
    for(elem in this)
        if (f(elem)) list += elem
    return list
}
fun List<Int>.myFilter2(f: (Int) -> Boolean): List<Int> {
    val ini = this // Tenho de criar esta variável auxiliar pois o buildList já tem um this (é a lista mutável auxiliar)
    val list:List<Int> = buildList{
        for (elem in ini)
            if (f(elem))
                this.add(elem)
    }
    return list
}

fun main() {
    var l1 = listOf(1,2,3,4,5)
    println(l1.myFilter { it % 3 == 0 })
    println(l1.myFilter2 { it % 3 == 0 })

}
