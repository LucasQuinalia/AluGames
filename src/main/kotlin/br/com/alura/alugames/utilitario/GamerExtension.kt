package br.com.alura.alugames.utilitario

import br.com.alura.alugames.dados.GamerEntity
import br.com.alura.alugames.dados.PlanoAssinaturaEntity
import br.com.alura.alugames.dados.PlanoAvulsoEntity
import br.com.alura.alugames.dados.PlanoEntity
import br.com.alura.alugames.modelo.*
import java.math.BigDecimal
import java.math.RoundingMode

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.nome, this.email, this.dataNascimento, this.usuario, this.id, this.plano.toEntity())
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}