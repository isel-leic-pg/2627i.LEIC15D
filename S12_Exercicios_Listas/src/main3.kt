enum class Level {HIGH, MEDIUM, LOW}

data class Product (val quality: Level,
    val price: Double)

data class Inflation(val change: Double,
    val quality: Level)

fun main() {

}

// Função extensão de List<Product> que recebe uma inflação
// Aplica a inflação a todos produtos
// Só mantêm os produtos com qualidade igual ou superior à
// indicada na data class inflaction recebida


operator fun List<Product>.plus(inflation: Inflation):
        List<Product> {
    var res: List<Product> = listOf()
    for (p in this) {
        if (p.quality >= inflation.quality)
            res += p.copy(price = p.price * inflation.change)
    }
    return res
}

fun List<Product>.plus2(inflation: Inflation):
        List<Product> {
   return this.filter{ it.quality >= inflation.quality }.
                map{ it.copy(price = it.price*inflation.change) }
}

// função extensão de List<Product >que recebe uma segunda lista de produtos
// com os novos preços para os produtos e devolve as inflações médias por cada tipo de qualidade.

// Inflações por cada produto e não médias
fun List<Product>.calcAvgInflation (newProd: List<Product>):
        List<Inflation> {
    var res: List<Inflation> = listOf()
    for (i in this.indices) {
        res += Inflation(this[i].price/newProd[i].price,
            this[i].quality)
    }

    return res
}


fun List<Product>.calcAvgInflation2 (newProd: List<Product>):
        List<Inflation> {
    var hsum = 0.0
    var hcount = 0
    var msum = 0.0
    var mcount = 0
    var lsum = 0.0
    var lcount = 0
    for (i in this.indices)
        when (this[i].quality) {
            Level.HIGH -> {
                hsum += this[i].price / newProd[i].price
                hcount ++
            }
            Level.MEDIUM -> {
                msum += this[i].price / newProd[i].price
                mcount ++
            }
            Level.LOW -> {
                lsum += this[i].price / newProd[i].price
                lcount ++
            }
        }
        var res: List<Inflation> = listOf()
    if (hcount > 0) res += Inflation(hsum / hcount,Level.HIGH)
    if (mcount > 0) res += Inflation(msum / mcount,Level.MEDIUM)
    if (lcount > 0) res += Inflation(lsum / lcount,Level.LOW)
    return res
}

fun List<Product>.calcAvgInflation3 (newProd: List<Product>):
        List<Inflation> {
    var res: List<Inflation> = listOf()
    for(l in Level.entries) {
        var sum = 0.0
        var count = 0.0
        for (i in this.indices)
            if (this[i].quality == l) {
                sum += this[i].price / newProd[i].price
                count++
            }
        if (count > 0)
            res+= Inflation(sum / count, l)
    }
    return res
}

// extensão list<Product>, recebe dois valores,
// remove os que forem maiores que o primeiro valor
// coloca no inicio os que forem menores que o 2º valor

fun List<Product>.limit(thresh:Double, best:Double): List<Product> {
    val filtered = this.filter{ it.price <= thresh}
    val bestElems =  filtered.filter{it.price < best}
    val rest = filtered.filter{it.price >= best}
    return bestElems+ rest
}