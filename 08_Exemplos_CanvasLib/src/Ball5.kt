data class Ball5 (val center:Point, val velocity:Offset,
                  val radius: Int, val color: Int)
// Utilizar a função copy permite alterar só o center e manter os outros valores da bola
fun Ball5.move() = copy(center= center+velocity)