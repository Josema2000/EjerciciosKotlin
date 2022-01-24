package com.example.filmapp

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.GetFilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetFilmUseCase
): ViewModel(), LifecycleObserver {

    private val filmLiveData = MutableLiveData<FilmDataView>()
    val film: LiveData<FilmDataView> = filmLiveData
    var job: Job? = null

    fun loadFilm() {
        val language = Locale.getDefault().language

        job = CoroutineScope(Dispatchers.IO).launch {
            val loadedFilm = useCase.execute(512195, language)
            withContext(Dispatchers.Main){
                loadedFilm?.let {
                    filmLiveData.value = FilmDataView(
                        it.title,
                        it.url,
                        it.nameDir,
                        it.rating
                    )
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
    data class FilmDataView(val title: String, val imageUrl: String?,val nameDir: String?, val rating: Double?)
