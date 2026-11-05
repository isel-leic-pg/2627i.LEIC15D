package main6
// Criei um package para não haver conflitos de nomes de valores e funções
import pt.isel.canvas.*
// Preciso de importar porque o Point está noutro package
import Ball5
import move
import Point
import Offset
import colision
import contains
import kotlin.ranges.random

const val WIDTH = 800
const val HEIGHT = 600

const val RADIUSMAX = 100
const val RADIUSMIN = 20
const val CROSS_COLOR = RED
const val CROSS_THICK = 5
const val MOVE_SIZE = 10
const val FRAMES = 30
const val NBALLS = 10

fun Canvas.draw(ball: Ball5) {
    val x = ball.center.x
    val y = ball.center.y
    // Como estou dentro do canvas não preciso de por "this."
    drawCircle(x,y, ball.radius, ball.color)
    drawLine(x,y-ball.radius/5,x,y+ball.radius/5,
        CROSS_COLOR, CROSS_THICK)
    drawLine(x-ball.radius/5,y,x+ball.radius/5,y,
        CROSS_COLOR,CROSS_THICK)
}
fun Canvas.draw(balls: List<Ball5>) {
    for(ball in balls) draw(ball)
}


fun main() {
    onStart{
        var over = false
        val canvas = Canvas(WIDTH,HEIGHT,WHITE)
        var balls: List<Ball5> = List(NBALLS) {
            val radius = (RADIUSMIN..RADIUSMAX).random()
            val x = (radius..canvas.width-radius).random()
            val y = (radius..canvas.height-radius).random()
            val color = (0..0xFFFFFF).random()
            Ball5( Point(x,y),randVelocityGenerator(),radius,color)
        }
        canvas.draw(balls)
        canvas.onTimeProgress(1000/FRAMES) {
            balls = balls.map{it.move().colision(canvas)}
            /*
            // A mesma coisa que primeiro fazer move e depois colision
            balls = balls.map{it.move()}
            balls = balls.map{it.colision(canvas)}
            */
            canvas.erase()
            if (over)
                canvas.drawImage("ISEL",canvas.mouse.x,canvas.mouse.y,
                    400,200)
            else
                canvas.draw(balls)
        }
        canvas.onMouseDown { mouse ->
            val p = Point(mouse.x, mouse.y)
            // Remove todas as que estiverem na posição do rato
            //balls = balls.filter{ p !in it }
            // Remove só a que estiver mais em cima na posição do rato
            // p in it => ball.contains(p)
            val clicked = balls.lastOrNull(){ p in it}
            // Se não clicarmos uma bola o valor será "null" e daria erro no "-" se não
            // colocarmos o if
            if (clicked != null)
                balls = balls - clicked
            else {
                // Este exemplo nãoestá no enunciado, é para acrescentar uma bola se "falharmos" apagar
                // Neste caso deviamos ter funções randomRadius e randomColor
                // porque estamos a usar mais que uma vez
                balls +=  Ball5( p,randVelocityGenerator(),
                    (RADIUSMIN..RADIUSMAX).random(),
                    (0..0xFFFFFF).random())
            }
            if (balls.isEmpty()) {
                // Deviam ser constantes
                over = true
                canvas.onTime(3000) { canvas.close() }
            }

        }


    }
    onFinish {  }
}

fun randVelocityGenerator(): Offset = Offset((-MOVE_SIZE..MOVE_SIZE).random(), (-MOVE_SIZE..MOVE_SIZE).random())
