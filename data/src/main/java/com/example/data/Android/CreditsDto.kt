package com.example.data.Android

import com.google.gson.annotations.SerializedName

data class CreditsDto(
    @SerializedName("cast") val role: List<CastDto>
)
