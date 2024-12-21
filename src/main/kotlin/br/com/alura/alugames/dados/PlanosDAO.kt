package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Plano
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {

    override fun toEntity(objeto: Plano): PlanoEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return entity.toModel()
    }
}
