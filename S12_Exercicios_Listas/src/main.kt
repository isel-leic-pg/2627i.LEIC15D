import pt.isel.canvas.*

enum class Dir { NORTH, EAST, SOUTH, WEST }
data class Loc( // Localização geográfica
    val lat: Double, // latitude em graus: North(+)/South(-)
    val lon: Double // longitude em graus: East(+)/West(-)
)
data class Move(val dir: Dir, val offset: Double)

fun main() {
    val lisbon = Loc(38.7223, -9.1393)
    println(lisbon.path( listOf(Move(Dir.NORTH, 2.4273),Move(Dir.EAST, 0.5284)) ))
}

operator fun Loc.plus(move: Move):Loc = when( move.dir ) {
    Dir.NORTH -> Loc( lat + move.offset, lon)
    Dir.SOUTH -> copy(lat = lat-move.offset )
    Dir.EAST -> Loc(lat, lon + move.offset)
    Dir.WEST -> copy(lon = lon-move.offset)
}

fun Loc.path(moves: List<Move>) : List<Loc> {
    var res:List<Loc> = listOf(this)
    for (m in moves) {
        res += res.last() + m
    }
    return res
}

//: List<Loc> {
//    var curr: Loc = this
//    return listOf(this) + moves.map{ curr = curr+it; curr }
//}