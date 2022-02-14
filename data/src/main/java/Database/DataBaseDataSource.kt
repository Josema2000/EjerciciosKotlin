package database

import Database.AppDatabase
import Database.FilmEntity
import com.example.domain.Film
import javax.inject.Inject

class DatabaseDataSource @Inject constructor(

    private val database: AppDatabase

) {

    suspend fun getFilms(): List<Film> {
        return database.FilmDao().getFilms().map { it.toDomain() }
    }

    suspend fun getFilm(id: Int): Film? {
        return database.FilmDao().getFilms(id)?.toDomain()
    }

    suspend fun updateFilms(films: List<Film>){
        database.FilmDao().insertAll(films.map { it.toEntity() })
    }

    suspend fun clearFilms() {
        database.FilmDao().deleteAll()
    }

    private fun FilmEntity.toDomain(): Film = Film(title, imageUrl, nameDir, description, rating, id, videoId)

    private fun Film.toEntity(): FilmEntity = FilmEntity(id,title, url, nameDir, description, rating, videoId)
}