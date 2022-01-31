package com.example.data.Android

import com.example.domain.Film
import com.example.domain.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val serverDataSource: ServerDataSource
    ): FilmRepository{
    override suspend fun getFilm(id: Int, language: String): Film? {
        return runCatching {
            serverDataSource.getFilm(id, language)
        }.getOrNull()
    }

    override suspend fun getFilms(language: String): List<Film>? {
        return runCatching {
            serverDataSource.getFilms(language)
        }.getOrNull()
    }
}