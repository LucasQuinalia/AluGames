package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.*
import br.com.alura.alugames.utilitario.criaGamer
import br.com.alura.alugames.utilitario.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {
    private fun consomeDados(endereco:String): String {
        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())

        return response.body()
    }

    fun buscaJogo(id:String): InfoJogo? {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consomeDados(endereco)

        val gson = Gson()

        var meuInfoJogo: InfoJogo? = null

        val resultado = kotlin.runCatching {
            meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        }

        resultado.onFailure {
            println("Jogo não encontrado, digite outro id.")
            return null
        }

        return meuInfoJogo
    }

    fun buscaJogoJson(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consomeDados(endereco)

        val gson = Gson()

        val meuGamerTipo = object : TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogo: List<InfoJogoJson> = gson.fromJson(json, meuGamerTipo)

        val listaJogoConvertida = listaJogo.map { InfoJogoJson -> InfoJogoJson.criaJogo() }

        return listaJogoConvertida
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consomeDados(endereco)

        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map { InfoGamerJson -> InfoGamerJson.criaGamer() }

        return listaGamerConvertida
    }
}