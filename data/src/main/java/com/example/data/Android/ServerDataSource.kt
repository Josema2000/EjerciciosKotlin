package com.example.data.Android

import com.example.domain.Film
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ServerDataSource @Inject constructor(){
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: FilmApi = retrofit.create(FilmApi::class.java)

    suspend fun getFilm(id: Int, language: String): Film {
        val filmDto = api.getFilm(id,language)
        val creditsDto = api.getCredits(id)
        val director = creditsDto.role.firstOrNull { it.role=="Directing" }?.name ?: ""
        val image = "https://image.tmdb.org/t/p/w500${filmDto.imageUrl}"

        val video = api.getVideos(id, language).results.filter {
            it.site == "Youtube"
        }.firstOrNull { it.type == "Trailer" }?.id

        return Film(filmDto.title, image, director, filmDto.description, filmDto.rating, filmDto.id, video)
    }

suspend fun getFilms(language:String): List<Film> {
    return api.getUpcoming(language).films.map {
        Film(it.title, getFullUrl(it.imageUrl), null, it.description, it.rating, it.id, null)
    }
}

private fun getFullUrl(imageUrl: String?) =
    imageUrl?.let {
        "https://image.tmdb.org/t/p/w500$it"
    }
}