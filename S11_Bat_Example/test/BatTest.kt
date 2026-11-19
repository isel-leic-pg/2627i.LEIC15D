import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BatTest {
    @Test
    fun moveTest() {
        var bat = Bat(20,150,100,
            100..200, 0..200,
            Direction.RIGHT,20)
        // RIGHT
        assertEquals(bat.copy(x=170), bat.move(), "RIGHT caso normal")
        bat = bat.copy(x=190, direction = Direction.LEFT)
        assertEquals(
            bat.copy(x=200),
            bat.move(), "RIGHT caso limite")
    }

}