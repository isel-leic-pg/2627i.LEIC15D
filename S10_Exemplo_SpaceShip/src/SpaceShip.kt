import pt.isel.canvas.*

private const val WIDTH: Int = 50
private const val HEIGHT: Int = 10
private const val CWIDTH: Int = 4
private const val CHEIGHT: Int = 5
private const val YOFFSET: Int = 50

/**
 * Represents the user spaceship that moves horizontally with the mouse
 * @property x The x position of the ship
 */
data class SpaceShip (
    val x: Int,
    // val shot: Shot
)

/**
 *
 */
fun SpaceShip.move(toX: Int, limitX: Int):SpaceShip {
    val limits = (WIDTH/2)..(limitX-WIDTH/2)
    val newX = if (toX in limits) toX else x
    return SpaceShip(newX)
}

/**
 *
 */
fun Canvas.show(ship: SpaceShip) {
    drawRect(ship.x-WIDTH/2, height-YOFFSET,WIDTH,HEIGHT,GREEN)
    drawRect(x=ship.x-CWIDTH/2, height-YOFFSET-CHEIGHT ,CWIDTH,CHEIGHT,YELLOW)
}








