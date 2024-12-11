package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import java.util.Scanner


fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite o código do jogo que deseja buscar:")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()
    val informacaoJogo = buscaApi.buscaJogo(busca)

    if (informacaoJogo != null) {
        val meuJogo = Jogo(informacaoJogo?.info?.title, informacaoJogo?.info?.thumb)
        println("Deseja inserir uma descrição no jogo? S/N")
        val resposta = leitura.nextLine()
        if (resposta.equals("s", true)) {
            println("Digite a descrição:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }
}