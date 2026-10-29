data class Point (val x:Int, val y:Int)

data class Offset (val dx:Int, val dy:Int)

// Keyword "operator" numa função extensão com o nome "plus" permite usar o operador +
operator fun Point.plus(offset: Offset) = Point(x+offset.dx, y+offset.dy)
