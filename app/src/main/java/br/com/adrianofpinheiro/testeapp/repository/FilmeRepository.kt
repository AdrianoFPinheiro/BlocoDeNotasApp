package br.com.adrianofpinheiro.testeapp.repository

import br.com.adrianofpinheiro.testeapp.api.getNotaAPI
import br.com.adrianofpinheiro.testeapp.model.Filme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FilmeRepository {

    fun buscarTodos(onComplete: (List<Filme>?) -> Unit,
                    onError: (Throwable?) -> Unit
    ) {
        getNotaAPI()
                .buscarTodos()
                .enqueue(object : Callback<List<Filme>> {
                    override fun onFailure(call: Call<List<Filme>>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<List<Filme>>?, response: Response<List<Filme>>?) {
                        onComplete(response?.body())
                    }
                })
    }

}