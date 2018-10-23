package br.com.adrianofpinheiro.testeapp.api

import br.com.adrianofpinheiro.testeapp.model.Filme
import retrofit2.Call
import retrofit2.http.*

interface FilmeAPI {
    @GET("/api/Movies")
    fun buscarTodos(): Call<List<Filme>>


}