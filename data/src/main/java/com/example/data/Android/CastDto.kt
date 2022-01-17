package com.example.data.Android

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("known_for_department") val role: String,
    @SerializedName("name") val name: String
)
