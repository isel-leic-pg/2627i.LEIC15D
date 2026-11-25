
data class RGB (val red:Int, val green: Int, val blue:Int)
enum class Color(val rgb:RGB) {
    RED (RGB(255,0,0)),
    GREEN(RGB(0,255,0)),
    BLUE(RGB(0,0,255)),
    GREY(RGB(100,100,100))}

data class Player(val color: Color, val hp: Int)

fun main() {
    println(Color.RED.toString()+1)
    println(Color.BLUE.ordinal)
    println(Color.RED < Color.BLUE)
    println(Color.entries - Color.GREEN)
    println(Color.GREEN.rgb.red)
    println(Color.GREEN.rgb)
}

// Se a cor recebida for:
//  Vermelha: Se o jogador for vermelho duplica o hp, senão fica a metade.
//  Verde: Se o jogador for verde ou cinzento não faz nada senão fica com metade.
//  Azul: Se o jogador for vermelho fica a zero, senão não faz nada.
//  Cinzento: Coloca a HP a 10 e muda a cor para cinzento

operator fun Player.plus(c: Color): Player =
    when (c){
        Color.RED -> copy(hp=if (color == Color.RED) hp*2 else hp/2)
        Color.GREEN -> if (color == Color.GREEN ||color == Color.GREY) this
                     else copy(hp = hp/2)
        Color.BLUE ->  copy(hp=if (color == Color.RED) 0 else hp)
        Color.GREY -> copy(hp=0,color= Color.GREY)
    }

// Aplicar a cor a cada jogador e todos os jogadores de cor igual
// à recebida devem ficar no inicio
// considera-se a cor final do jogador
fun List<Player>.apply(c:Color):List<Player> {
    val list = this.map{it + c}
    var lstart: List<Player> = listOf()
    var lend: List<Player> = listOf()
    for (p in list) {
        if (p.color == c) lstart += p
        else lend += p
    }
    return lstart + lend
}

//  considera-se a cor inicial
fun List<Player>.apply2(c:Color):List<Player> {
    var lstart: List<Player> = listOf()
    var lend: List<Player> = listOf()
    for (p in this) {
        val pa = p + c
        if (p.color == c) lstart += pa
        else lend+=pa
    }
    return lstart+lend
}

// ordenar os players pela cor considerando a ordem na enumeração
// Força bruta (pode ter ums pontinhos a menos)
fun List<Player>.orderColor():List<Player> {
    var lr: List<Player> = listOf()
    var lg: List<Player> = listOf()
    var lb: List<Player> = listOf()
    var lgr: List<Player> = listOf()
    for(p in this) when(p.color) {
        Color.RED -> lr += p
        Color.GREEN -> lg += p
        Color.BLUE -> lb += p
        Color.GREY -> lgr += p
    }
    return lr + lg + lb + lgr
}
// melhor
fun List<Player>.orderColor2():List<Player> {
    var res:List<Player> = listOf()
    for(c in Color.entries)
        res += this.filter{it.color == c}
    return res
}
