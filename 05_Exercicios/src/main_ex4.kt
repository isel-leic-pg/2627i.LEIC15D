
val PI = 3.141592653589793
fun circleArea(radius:Int) = PI * radius * radius
fun circleCircunference(radius: Int) = 2 * PI * radius


fun main() {
    println("Insira o raio do círculo:")
    val raio = readln().toInt()
    println("Circulo de raio $raio")
    println("Área: ${circleArea(raio)}")
    println("Perímetro: ${circleCircunference(raio)}")
}
