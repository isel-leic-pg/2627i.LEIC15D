data class Ball (val center:Point, val radius: Int, val color: Int)
// Utilizar a função copy permite alterar só o center e manter os outros valores da bola
fun Ball.move(offset:Offset) = copy(center= center+offset)