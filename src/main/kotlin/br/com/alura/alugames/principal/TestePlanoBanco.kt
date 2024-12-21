package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.PlanosDAO
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.modelo.PlanoAvulso
import java.math.BigDecimal

fun main() {
    val avulso = PlanoAvulso("BRONZE")
    val prata = PlanoAssinatura("PRATA", BigDecimal(9.90), 3, BigDecimal(0.15))
    val ouro = PlanoAssinatura("OURO", BigDecimal(19.90), 5, BigDecimal(0.20))
    val platina = PlanoAssinatura("PLATINA", BigDecimal(29.90), 10, BigDecimal(0.30))
    val diamante = PlanoAssinatura("DIAMANTE", BigDecimal(49.90), 20, BigDecimal(0.50))

    val manager = Banco.getEntityManager()
    val planosDAO = PlanosDAO(manager)

    planosDAO.adicionar(avulso)
    planosDAO.adicionar(prata)
    planosDAO.adicionar(ouro)
    planosDAO.adicionar(platina)
    planosDAO.adicionar(diamante)

    val listaPlanos = planosDAO.getLista()
    println(listaPlanos)

    manager.close()
}
