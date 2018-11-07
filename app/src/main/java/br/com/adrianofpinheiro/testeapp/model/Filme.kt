package br.com.adrianofpinheiro.testeapp.model

import com.google.gson.annotations.SerializedName

data class Filme(

        var id: String?,
        var title: String,
        var overview: String,
        var duration: String,
        var release_year: String,
        @SerializedName("cover_url")val coverUrl: String
 //       @SerializedName("backdrops_url")val backdropsUrl: String

)