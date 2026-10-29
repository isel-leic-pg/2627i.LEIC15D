package main2
// Criei um package para não haver conflitos de nomes de valores e funções
import pt.isel.canvas.*

const val WIDTH = 800
const val HEIGHT = 600

const val RADIUS = 100
const val COLOR = GREEN
const val CROSS_COLOR = RED
const val CROSS_THICK = 5

fun drawBall(x:Int, y:Int, canvas: Canvas) {
    canvas.drawCircle(x,y,RADIUS,COLOR)
    canvas.drawLine(x,y-RADIUS/5,x,y+RADIUS/5,
        CROSS_COLOR,CROSS_THICK)
    canvas.drawLine(x-RADIUS/5,y,x+RADIUS/5,y,
        CROSS_COLOR,CROSS_THICK)
}

fun main() {
    onStart{
        val canvas = Canvas(WIDTH,HEIGHT,WHITE)
        canvas.onMouseMove { mouse ->
            canvas.erase()
            drawBall(mouse.x,mouse.y,canvas)
        }

    }
    onFinish {  }
}
