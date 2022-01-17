package com.example.data.Android

import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName ("id") val id: Int,
    @SerializedName ("original_title") val title: String,
    @SerializedName ("overview") val description: String,
    @SerializedName ("vote_average") val rating: Double,
    @SerializedName ("logo_path") val imageUrl: String
)
