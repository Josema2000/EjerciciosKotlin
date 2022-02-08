package Database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FilmEntity::class], version = 1)

abstract class AppDatabase: RoomDatabase() {
    abstract fun FilmDao(): FilmDao
}