package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.io.FileWriter
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogoJson()

//    println(listaGamers)
//    println(listaJogos)

    val gamer1 = listaGamers.get(3)
    val jogo1 = listaJogos.get(10)
    val jogo2 = listaJogos.get(13)
    val jogo3 = listaJogos.get(2)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo4 = Periodo(LocalDate.of(2023,8,2), LocalDate.of(2023,8,15))

    gamer1.alugaJogo(jogo1, periodo1)
    gamer1.alugaJogo(jogo2, periodo2)
    gamer1.alugaJogo(jogo3, periodo3)
    gamer1.alugaJogo(jogo2, periodo4)

//    println(gamer1.jogosAlugados)
//    println(gamer1.jogosDoMes(12))

    val gamer2 = listaGamers.get(5)
    gamer2.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)

    gamer2.alugaJogo(jogo1, periodo1)
    gamer2.alugaJogo(jogo2, periodo2)
    gamer2.alugaJogo(jogo3, periodo3)
    gamer2.alugaJogo(jogo2, periodo2)

//    println(gamer2.jogosAlugados)

    gamer2.recomendar(7)
    gamer2.recomendar(10)
    gamer2.recomendar(8)

//    println(gamer2)

    gamer2.alugaJogo(jogo2, periodo2)

//    println(gamer2.jogosAlugados)

    gamer2.recomendarJogo(jogo1, 5)
    gamer2.recomendarJogo(jogo2, 8)

    gamer1.recomendarJogo(jogo1, 8)
    gamer1.recomendarJogo(jogo2, 10)

//    println(gamer2.jogosRecomendados)
//    println(gamer1.jogosRecomendados)

    val jogoResidentVillage = listaJogos.get(10)
    val jogoSpider = listaJogos.get(13)
    val jogoTheLastOfUs = listaJogos.get(2)
    val jogoDandara = listaJogos.get(5)
    val jogoAssassins = listaJogos.get(4)
    val jogoCyber = listaJogos.get(6)
    val jogoGod = listaJogos.get(7)
    val jogoSkyrim = listaJogos.get(18)

    gamer2.recomendarJogo(jogoResidentVillage, 7)
    gamer2.recomendarJogo(jogoTheLastOfUs, 10)
    gamer2.recomendarJogo(jogoAssassins, 8)
    gamer2.recomendarJogo(jogoCyber, 7)
    gamer2.recomendarJogo(jogoGod, 10)
    gamer2.recomendarJogo(jogoDandara, 8)
    gamer2.recomendarJogo(jogoSkyrim, 8)
    gamer2.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create()
    val serializacao = gson.toJson(gamer2.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados.json")
    arquivo.writeText(serializacao)
}