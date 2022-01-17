package com.example.data.Android

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "e8dbf25d1d8783bf758287f09a31875a"

interface FilmApi {

    @GET( "movie/{id}")

    suspend fun getFilm(@Path("id")filmId:Int,
                        @Query("language") language:String,
                        @Query("api_key") apiKey:String = API_KEY): FilmDto
}