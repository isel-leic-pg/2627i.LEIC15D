package main3
// Criei um package para não haver conflitos de nomes de valores e funções
import pt.isel.canvas.*
// Preciso de importar porque o Point está noutro package
import Point
import plus
import Offset

const val WIDTH = 800
const val HEIGHT = 600

const val RADIUS = 100
const val COLOR = GREEN
const val CROSS_COLOR = RED
const val CROSS_THICK = 5
const val MOVE_SIZE = 10

fun Canvas.drawBall(center: Point) {
    // Como estou dentro do canvas não preciso de por "this."
    drawCircle(center.x,center.y,RADIUS,COLOR)
    drawLine(center.x,center.y-RADIUS/5,
        center.x,center.y+RADIUS/5,
        CROSS_COLOR,CROSS_THICK)
    drawLine(center.x-RADIUS/5,center.y,
        center.x+RADIUS/5,center.y,
        CROSS_COLOR,CROSS_THICK)
}


fun main() {
    onStart{
        val canvas = Canvas(WIDTH,HEIGHT,WHITE)
        var ballCenter = Point(canvas.width/2,canvas.height/2)
        canvas.drawBall(ballCenter)
        canvas.onKeyPressed { key ->
            val move:Offset =
                when (key.code) {
                    DOWN_CODE -> Offset(0,MOVE_SIZE)
                    UP_CODE -> Offset(0,-MOVE_SIZE)
                    LEFT_CODE -> Offset(-MOVE_SIZE,0)
                    RIGHT_CODE -> Offset(MOVE_SIZE,0)
                    else -> Offset(0,0)
                }
            // Se não usassemos a keyword operator só podiamos fazer desta forma
            // ballCenter = ballCenter.plus(move)
            // COm a keyword operator na função plus podemos utilizar os operadores com +
            ballCenter += move
            canvas.erase()
            canvas.drawBall(ballCenter)
        }

    }
    onFinish {  }
}
