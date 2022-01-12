package com.example.filmapp

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.FilmUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val useCase: FilmUseCase
): ViewModel(), LifecycleObserver {

    private val filmLiveData = MutableLiveData<FilmDataView>()
    val film: LiveData<FilmDataView> = filmLiveData

    fun loadFilm() {
        val loadedFilm = useCase.execute()
        filmLiveData.value = FilmDataView(loadedFilm.title, loadedFilm.nameDir)
    }

    data class FilmDataView(val title:String, val nameDir: String)
}
