

fun main() {
    val numA = (1..20).random()
    val numB = (1..20).random()
    val interval = if (numA < numB) numA..numB else numA downTo numB
    for (i in interval) println(i)
  }
