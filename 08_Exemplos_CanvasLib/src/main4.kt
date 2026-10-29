package main4
// Criei um package para não haver conflitos de nomes de valores e funções
import pt.isel.canvas.*
// Preciso de importar porque o Point está noutro package
import Ball
import move
import Point
import plus
import Offset

const val WIDTH = 800
const val HEIGHT = 600

const val RADIUS = 100
const val COLOR = GREEN
const val CROSS_COLOR = RED
const val CROSS_THICK = 5
const val MOVE_SIZE = 3
const val FRAMES = 30


fun Canvas.draw(ball: Ball) {
    val x = ball.center.x
    val y = ball.center.y
    // Como estou dentro do canvas não preciso de por "this."
    drawCircle(x,y, RADIUS, COLOR)
    drawLine(x,y-RADIUS/5,x,y+RADIUS/5,
        CROSS_COLOR, CROSS_THICK)
    drawLine(x-RADIUS/5,y,x+RADIUS/5,y,
        CROSS_COLOR,CROSS_THICK)
}


fun main() {
    onStart{
        val canvas = Canvas(WIDTH,HEIGHT,WHITE)
        var ball = Ball(Point(canvas.width/2,canvas.height/2),RADIUS,COLOR)
        canvas.draw(ball)
        canvas.onTimeProgress(1000/FRAMES) {
            ball = ball.move(Offset(0,MOVE_SIZE))
            canvas.erase()
            canvas.draw(ball)
        }
        canvas.onMouseDown { mouse ->
            ball = ball.copy(center = Point(mouse.x,mouse.y))
        }


    }
    onFinish {  }
}
