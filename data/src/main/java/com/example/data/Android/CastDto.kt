package com.example.data.Android

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("cast") val role: String,
    @SerializedName("name") val name: String
)
