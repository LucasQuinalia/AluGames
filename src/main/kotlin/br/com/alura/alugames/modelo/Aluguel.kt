package br.com.alura.alugames.modelo

import java.math.BigDecimal

data class Aluguel(
    val jogo:Jogo,
    val gamer:Gamer,
    val periodo: Periodo) {

    val valorDoAluguel:BigDecimal = gamer.plano.obterValor(this)
    
    override fun toString(): String {
        return "\nAluguel do jogo ${jogo.titulo} por ${gamer.nome} pelo valor de R$ $valorDoAluguel"
    }
}
