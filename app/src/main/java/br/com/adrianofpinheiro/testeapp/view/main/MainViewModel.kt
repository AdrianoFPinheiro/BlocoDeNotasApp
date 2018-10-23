package br.com.adrianofpinheiro.testeapp.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.adrianofpinheiro.testeapp.model.Filme
import br.com.adrianofpinheiro.testeapp.repository.FilmeRepository

class MainViewModel : ViewModel() {

    val filmeRepository = FilmeRepository()
    val filmes: MutableLiveData<List<Filme>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun buscarTodos() {
        isLoading.value = true
        filmeRepository
                .buscarTodos(
                        onComplete = {
                            isLoading.value = false
                            filmes.value = it

                        }, onError = {
                    isLoading.value = false
                    filmes.value = arrayListOf()
                })

    }

}