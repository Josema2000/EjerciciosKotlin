package com.example.data.Android

import com.google.gson.annotations.SerializedName

class FilmOverviewDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val description: String,
    @SerializedName("vote_average") val rating: Double,
    @SerializedName("poster_path") val imageUrl: String?
)