package br.com.alura.alugames.utilitario

import br.com.alura.alugames.dados.PlanoAssinaturaEntity
import br.com.alura.alugames.dados.PlanoAvulsoEntity
import br.com.alura.alugames.dados.PlanoEntity
import br.com.alura.alugames.modelo.Plano
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.modelo.PlanoAvulso
import java.math.BigDecimal
import java.math.RoundingMode

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(this.tipo, this.mensalidade.toDouble(), this.jogosIncluidos, this.percentualDescontoReputacao.toDouble(), this.id)
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(this.tipo, BigDecimal(this.mensalidade).setScale(2, RoundingMode.HALF_EVEN), this.jogosIncluidos, BigDecimal(this.percentualDescontoReputacao).setScale(2, RoundingMode.HALF_EVEN), this.id)
    } else {
        PlanoAvulso(this.tipo, this.id)
    }
}