package com.example.data.Android

import com.example.domain.Film
import javax.inject.Inject

class HardcodedDataSource @Inject constructor(){
    fun getFilm(): Film {
        return Film("La Purga", "", "James DeMonaco", "La mejor peli", 8.0,0)
    }
}