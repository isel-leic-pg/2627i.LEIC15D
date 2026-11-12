import com.sun.tools.javac.main.Option
import pt.isel.canvas.*

data class Game(
   // val area: Area,
   // val alienShots: List<Shot>,
    val ship: SpaceShip,
    val over: Boolean
)


fun main() {
    onStart { Canvas(700,500,BLACK).startGame()}
    onFinish {  }
}

private fun Canvas.startGame() {
    var game = Game(SpaceShip(width/2), false)
    //var ship = SpaceShip(width/2)
    show(game.ship)
    var x=0
    /*
    onTimeProgress(100) {
        x+=1
        erase()
        drawRect(x,200,100,50, BLUE)
        show(game.ship)
    }
    */
    onMouseMove { mouse ->
        game = Game(ship = game.ship.move(mouse.x, width), over = game.over)
        //game.copy(ship = game.ship.move(mouse.x, width))
        erase()
        show(game.ship)
    }
}

