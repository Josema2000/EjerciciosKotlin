package com.example.data.Android

import com.google.gson.annotations.SerializedName

class FilmListResultDto(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val films: List<FilmOverviewDto>
)
