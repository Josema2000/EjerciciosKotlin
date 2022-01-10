package com.example.data.Android

import com.example.domain.Film
import com.example.domain.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val dataSource: HardcodedDataSource
    ): FilmRepository{
    override fun getFilm(): Film {
        return dataSource.getFilm()
    }
}