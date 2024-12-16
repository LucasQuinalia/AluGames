package br.com.alura.alugames.modelo

import com.google.gson.annotations.Expose
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

data class Jogo(@Expose val titulo:String?, @Expose val capa: String?):Recomendavel {
    var preco = BigDecimal("0.0")
    var descricao:String? = null

    private val listaNotas = mutableListOf<Int>()

    fun Double.formatoComDuasCasasDecimais(): Double {
        val decimalFormat = DecimalFormat("#.00", DecimalFormatSymbols(Locale.US))
        return decimalFormat.format(this).toDouble()
    }

    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10) {
            println("Nota inválida. Insira uma nota entre 1 e 10")
        } else {
            listaNotas.add(nota)
        }
    }


    constructor(titulo: String?, capa: String?, preco:BigDecimal?, descricao:String?):
            this(titulo, capa) {
                this.preco = preco!!
                this.descricao = descricao
            }

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Título: $titulo\n" +
                "Capa: $capa \n" +
                "Preço: $preco \n" +
                "Descrição: $descricao\n" +
                "Reputação: $media"
    }
}