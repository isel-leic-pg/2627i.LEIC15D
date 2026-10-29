package main4
// Criei um package para não haver conflitos de nomes de valores e funções
import pt.isel.canvas.*
// Preciso de importar porque o Point está noutro package
import Ball
import move
import Point
import plus
import Offset
import main2.COLOR
import main2.CROSS_COLOR
import main2.CROSS_THICK
import main2.RADIUS

const val WIDTH = 800
const val HEIGHT = 600

const val RADIUS = 100
const val COLOR = GREEN
const val CROSS_COLOR = RED
const val CROSS_THICK = 5
const val MOVE_SIZE = 10

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
       //     canvas.erase()

    }
    onFinish {  }
}
