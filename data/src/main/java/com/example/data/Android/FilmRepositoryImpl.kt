package com.example.data.Android

import com.example.domain.Film
import com.example.domain.FilmRepository

class FilmRepositoryImpl: FilmRepository {
    override fun getFilm(): Film {
        return Film("La Purga", "", 8.0, "James DeMonaco")
    }
}