package com.example.data.Android

import Database.RoomModule
import com.example.domain.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(includes = [RoomModule::class])
abstract class DataModule {
    @Binds
    abstract fun bindFilmRepository(impl: FilmRepositoryImpl): FilmRepository
}