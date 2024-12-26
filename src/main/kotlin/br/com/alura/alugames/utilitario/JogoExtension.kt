package br.com.alura.alugames.utilitario

import br.com.alura.alugames.dados.JogoEntity
import br.com.alura.alugames.modelo.*
import java.math.BigDecimal
import java.math.RoundingMode

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, BigDecimal(this.preco), this.descricao)
}

fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(this.titulo, this.capa, this.preco.toDouble(), this.descricao)
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(this.titulo, this.capa, BigDecimal(this.preco).setScale(2, RoundingMode.HALF_EVEN), this.descricao, this.id)
}