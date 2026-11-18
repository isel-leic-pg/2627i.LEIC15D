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

