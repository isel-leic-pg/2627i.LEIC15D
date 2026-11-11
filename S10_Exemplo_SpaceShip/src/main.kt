import com.sun.tools.javac.main.Option
import pt.isel.canvas.*

fun main() {
    onStart { Canvas(700,500,BLACK).startGame()}
    onFinish {  }
}

private fun Canvas.startGame() {
    var ship = SpaceShip(width/2)
    show(ship)
    onMouseMove { mouse ->
        ship = ship.move(mouse.x, width)
        erase()
        show(ship)
    }
}

