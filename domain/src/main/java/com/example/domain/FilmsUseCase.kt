package com.example.domain

import javax.inject.Inject

class FilmsUseCase @Inject constructor(
        private val repository: FilmRepository
) {
        suspend fun execute(language:String) = repository.getFilms(language)
}




