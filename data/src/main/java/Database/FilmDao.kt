package Database

import androidx.room.*

@Dao

interface FilmDao {

    @Query("SELECT * FROM FilmEntity")
    suspend fun getFilms(): List<FilmEntity>

    @Query("SELECT * FROM FilmEntity WHERE id LIKE :FilmId")
    suspend fun getFilms(FilmId: Int): FilmEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(films: List<FilmEntity>)

    @Delete
    suspend fun deleteFilm(film: FilmEntity)

    @Query("DELETE from FilmEntity")
    suspend fun deleteAll()

}