import pt.isel.canvas.*

fun main() {
    onStart{
        val canvas = Canvas(600,600)
        canvas.drawCircle(100,100,100,BLUE)
    }
    onFinish {  }
}
