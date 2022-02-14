package com.example.data.Android

import com.example.domain.Film
import com.example.domain.FilmRepository
import database.DatabaseDataSource
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val serverDataSource: ServerDataSource,
    private val databaseDataSource: DatabaseDataSource
    ): FilmRepository{
    override suspend fun getFilm(id: Int, language: String): Film? {
        return runCatching {
            val filmFromServer = serverDataSource.getFilm(id, language)
            databaseDataSource.clearFilms()
            databaseDataSource.updateFilms(listOf(filmFromServer))
            filmFromServer
        }.getOrNull() ?: databaseDataSource.getFilm(id)
    }

    override suspend fun getFilms(language: String): List<Film>? {
        return runCatching {
            val filmsFromServer = serverDataSource.getFilms(language)
            databaseDataSource.clearFilms()
            databaseDataSource.updateFilms(filmsFromServer)
            filmsFromServer
        }.getOrNull() ?: databaseDataSource.getFilms()
    }
}