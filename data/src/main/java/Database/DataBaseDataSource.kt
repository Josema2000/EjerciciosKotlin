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

    suspend fun clearFilms() {
        database.FilmDao().deleteAll()
    }

    private fun FilmEntity.toDomain(): Film = Film(title, imageUrl, nameDir, description, rating, id, videoId)

}