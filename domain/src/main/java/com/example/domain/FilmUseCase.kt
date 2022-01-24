package com.example.domain

import javax.inject.Inject

class GetFilmUseCase @Inject constructor(private val repository: FilmRepository){
        suspend fun execute(id: Int, language: String) = repository.getFilm(id, language)
}
