package com.example.domain

interface FilmRepository{
    suspend fun getFilm(id: Int, language: String): Film?

    suspend fun getFilms(language: String): List<Film>?
}