package com.example.domain

import javax.inject.Inject

class FilmUseCase @Inject constructor(private val repository: FilmRepository){
        fun execute() = repository.getFilm()
}
