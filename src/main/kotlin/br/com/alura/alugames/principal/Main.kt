package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import tranformarEmIdade
import java.util.Scanner


fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Idade do gamer: " + gamer.dataNascimento?.tranformarEmIdade())

    do {
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
            println(meuJogo.titulo)
            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar por mais um jogo? S/N")
        val resposta = leitura.nextLine()
    } while (resposta.equals("s", true))

    println("Jogos buscados:\n" +
            gamer.jogosBuscados)

    println("Jogos buscados em ordem alfabética:\n" +
            gamer.jogosBuscados.sortBy {
                it.titulo
            })

    gamer.jogosBuscados.forEach {
        println("Título: " + it.titulo)
    }

    println("Jogos filtrados:\n" +
        gamer.jogosBuscados.filter {
            it.titulo?.contains("batman", true) ?: false
        })

    println("Deseja excluir algum item da sua lista de jogos? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("s", true)) {
        println(gamer.jogosBuscados)
        println("Qual jogo deseja excluir? Digite o índice.")
        val codigo = leitura.nextInt()
        gamer.jogosBuscados.removeAt(codigo)
        println(gamer.jogosBuscados)
    }

    println("Busca finalizada.")
}