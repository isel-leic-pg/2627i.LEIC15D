import pt.isel.canvas.Canvas

data class Ball5 (val center:Point, val velocity:Offset,
                  val radius: Int, val color: Int)
// Utilizar a função copy permite alterar só o center e manter os outros valores da bola
fun Ball5.move() = copy(center= center+velocity)

// Já resolve o problema do mouse colocar a bola muito perto do limite
// Verificamos se a velocidade está a fazer bola sair ou entrar na área
fun Ball5.colision(area:Canvas):Ball5 {
    var vx = velocity.dx
    var vy = velocity.dy
    if ((center.x-radius < 0 && velocity.dx < 0) ||
        (center.x+radius > area.width && velocity.dx > 0))
        vx = -vx
    if ((center.y-radius < 0 && velocity.dy < 0) ||
        (center.y+radius > area.height && velocity.dy > 0))
        vy = -vy
    return copy(velocity = Offset(vx, vy))
}

operator fun Ball5.contains(p:Point):Boolean =
    Math.sqrt(Math.pow((center.x-p.x).toDouble(),2.0)+
            Math.pow((center.y-p.y).toDouble(),2.0)) <= radius


/*
// Esta versão tem problemas quando o mouse clica muito perto da borda
fun Ball5.colision(area:Canvas):Ball5 {
    if (center.x-radius < 0 || center.x+radius > area.width)
        return copy(velocity = Offset(-velocity.dx,velocity.dy))
    if (center.y-radius < 0 || center.y+radius > area.height)
        return copy(velocity = Offset(velocity.dx,-velocity.dy))
    return this
}
*/
