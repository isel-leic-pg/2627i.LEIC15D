import pt.isel.canvas.*

private const val NUM_SPRITES = 3
private const val SPRITE_SIDE = 32

enum class Direction (val dx:Int,val dy:Int, val vertical:Boolean)
{
    LEFT(-1,0,false),
    RIGHT(1, 0, false) ,
    UP(0,-1, true),
    DOWN (0, 1, true)
}

fun Direction.turn():Direction =
    when (this) {
        Direction.LEFT -> Direction.RIGHT
        Direction.RIGHT -> Direction.LEFT
        Direction.UP -> Direction.DOWN
        Direction.DOWN -> Direction.UP
    }

data class Bat(val size:Int, val x: Int, val y: Int,
    val rangex:IntRange, val rangey:IntRange, val direction: Direction,
    val velocity: Int, val sprite:Int = 0,val spriteInc:Int = 1 )

fun Bat.animate(): Bat =
    when(sprite){
        0 -> copy(sprite = 1, spriteInc = 1)
        NUM_SPRITES-1 -> copy(sprite = NUM_SPRITES-2, spriteInc = -1)
        else -> copy(sprite =sprite + spriteInc)
    }

fun Bat.move(): Bat {
    var newx = x + direction.dx * velocity
    var newy = y + direction.dy * velocity
    var newdir = direction
    // Atenção se o morcego tiver 20px e o intervalo for de 100..200
    // o morcego irá ocupar o espaço de 100 a 220
    // Estou a considerar neste caso que dariamos 100..180 se quisessemos
    // que não ultrapassasse os 200
    if (newx !in rangex) {
        newdir = direction.turn()
        newx = if (newx > rangex.last) rangex.last
        else rangex.first
    }
    if (newy !in rangey) {
        newdir = direction.turn()
        newy = if (newy > rangey.last) rangey.last
        else rangey.first
    }
    return copy(x=newx,y=newy,direction=newdir)
}

fun Canvas.show(bat:Bat) {
    val x = SPRITE_SIDE * bat.sprite
    val sizeStr = "$x,0,$SPRITE_SIDE,$SPRITE_SIDE"
    drawImage("bat|$sizeStr",bat.x,bat.y,
           bat.size,bat.size)
}