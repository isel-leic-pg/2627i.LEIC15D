fun main() {
    val pontos1 = 12
    val pontos2 = 20
    if (pontos1 == pontos2) println("Empataram!")
    else println ("Ganhou o jogador "+
            if (pontos1 > pontos2) 1 else 2)
}
