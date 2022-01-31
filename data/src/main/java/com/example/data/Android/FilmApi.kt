package com.example.data.Android

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "e8dbf25d1d8783bf758287f09a31875a"
const val BASE_URL = "https://api.themoviedb.org/3/"

interface FilmApi {

    @GET( "movie/{id}")

    suspend fun getFilm(@Path("id")filmId:Int,
                        @Query("language") language:String,
                        @Query("api_key") apiKey:String = API_KEY): FilmDto

    @GET( "movie/{id}/credits")

    suspend fun getCredits(@Path("id")filmId:Int,
                        @Query("api_key") apiKey:String = API_KEY): CreditsDto

    @GET("movie/upcoming")
    suspend fun getUpcoming(@Query("language") language: String,
                            @Query("api_key") apiKey: String = API_KEY): FilmListResultDto
}