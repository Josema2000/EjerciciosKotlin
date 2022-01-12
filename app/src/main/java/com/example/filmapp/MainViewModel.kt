package com.example.filmapp

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.Film
import com.example.domain.FilmUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val useCase: FilmUseCase
): ViewModel(), LifecycleObserver {

    private val filmLiveData = MutableLiveData<Film>()
    val film: LiveData<Film> = filmLiveData

    fun loadFilm() {
        val loadedFilm = useCase.execute()
        filmLiveData.value = loadedFilm
    }
}
