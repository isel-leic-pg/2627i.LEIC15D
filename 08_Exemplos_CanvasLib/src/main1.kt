import pt.isel.canvas.*
const val WIDTH = 600
const val HEIGHT = 600
const val RADIUS = 150
const val THICKNESS = 10

fun main() {
    onStart{
        val canvas = Canvas(WIDTH,HEIGHT)
        canvas.drawCircle(canvas.width/2,canvas.height/2, RADIUS, RED)
        canvas.drawRect(canvas.width/2-RADIUS-THICKNESS,canvas.height/2-RADIUS-THICKNESS,
            2*(RADIUS+THICKNESS),2*(RADIUS+THICKNESS),BLUE,THICKNESS)
        val canvas2 = Canvas(WIDTH,HEIGHT)
        canvas2.drawImage("ISEL",canvas.width/4,canvas.width/4, canvas.width/2,canvas.width/4)
        canvas2.drawText(canvas.width/4,3*canvas.width/4, "Hello", BLACK, canvas.width/4)
    }
    onFinish {  }
}
