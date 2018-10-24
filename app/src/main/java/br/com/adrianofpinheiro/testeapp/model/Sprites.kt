package br.com.adrianofpinheiro.testeapp.model

import com.google.gson.annotations.SerializedName

data class Sprites(

        @SerializedName("cover_url")val cover_url: String,
        @SerializedName("backdrops_url")val backdrops_url: String

)