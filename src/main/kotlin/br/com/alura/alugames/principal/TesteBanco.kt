package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamersDAO
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import java.math.BigDecimal

fun main() {
    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", BigDecimal(5.99),"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogo2 = Jogo("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", BigDecimal(9.99),"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    val gamer1 = Gamer("Matheus", "matheus@email.com", "13/08/2001", "math-lux")
    val gamer2 = Gamer("Lucas", "lucas@email.com", "21/06/2005", "lexu")

    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    val gamerDAO = GamersDAO(manager)
//    jogoDAO.adicionar(jogo2)

//    val jogoRecuperado = jogoDAO.recuperarPeloId(4)
//    println(jogoRecuperado)
//
    gamerDAO.apagar(1)

//    gamerDAO.adicionar(gamer1)
//    gamerDAO.adicionar(gamer2)

    val listaJogos: List<Jogo> = jogoDAO.getLista()
    println(listaJogos)

    val listaGamers: List<Gamer> = gamerDAO.getLista()
    println(listaGamers)

    manager.close()
}