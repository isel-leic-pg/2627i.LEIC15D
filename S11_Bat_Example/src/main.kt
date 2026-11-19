import pt.isel.canvas.*

fun main() {
    // alguns exemplos de utilização de Enumerados
    for (dir in Direction.entries)
        println(dir)
    println(Direction.UP.ordinal)
    println(Direction.entries[2])
    println(""+Direction.entries.size+" "+
            Direction.entries.indices)
    println(Direction.UP > Direction.LEFT)

    onStart{
        Canvas(800,500, WHITE).startGame()
    }
    onFinish {  }

}

private fun Canvas.startGame() {
    var bat = Bat(50,100,150,
        100..300,100..200,
        Direction.RIGHT,10)
    show(bat)
    onTimeProgress(100) {
        bat = bat.move().animate()
        erase()
        show(bat)
    }
}
