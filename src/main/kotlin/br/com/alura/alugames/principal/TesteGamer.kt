import br.com.alura.alugames.modelo.Gamer

fun main () {
    val gamer1 = Gamer("Matheus", "matheus@email.com")
    println(gamer1)
    val gamer2 = Gamer("Lucas", "lucas@email.com", "21/06/2005", "lexu")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "03/08/2001"
        it.usuario = "mathlux"
    }.also {
        println(gamer1)
    }
}
