package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import java.math.BigDecimal
import java.math.RoundingMode
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity {
        return JogoEntity(objeto.titulo, objeto.capa, objeto.preco.toDouble(), objeto.descricao)
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(entity.titulo, entity.capa, BigDecimal(entity.preco).setScale(2, RoundingMode.HALF_EVEN), entity.descricao, entity.id)
    }
}