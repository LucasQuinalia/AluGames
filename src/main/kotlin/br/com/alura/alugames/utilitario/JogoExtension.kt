package br.com.alura.alugames.utilitario

import br.com.alura.alugames.modelo.InfoJogoJson
import br.com.alura.alugames.modelo.Jogo
import java.math.BigDecimal

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, BigDecimal(this.preco), this.descricao)
}