package br.com.adrianofpinheiro.testeapp.model

import com.google.gson.annotations.SerializedName

data class Filme(

        var id: String?,
        var title: String,
        var overview: String,
        var duration: String,
        var release_year: String,
        val coverUrl: Sprites
//        var backdrops_url: Sprites*/
)