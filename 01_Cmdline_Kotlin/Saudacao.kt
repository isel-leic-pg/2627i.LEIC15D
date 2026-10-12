fun main(args: Array<String>) {
    // Verificar se o utilizador passou algum argumento
    if (args.isNotEmpty()) {
        val nome = args[0] // O primeiro argumento (Input)
        println("Olá, $nome! Bem-vind@ ao Kotlin.") 
  	  // Imprime na consola (Output)
    } else {
        println("Olá! Por favor passe o nome como argumento.")
    }
}
