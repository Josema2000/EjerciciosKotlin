package com.example.data.Android

import com.example.domain.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindFilmRepository(impl: FilmRepositoryImpl): FilmRepository
}