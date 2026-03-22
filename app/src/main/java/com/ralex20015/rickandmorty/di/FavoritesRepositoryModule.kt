package com.ralex20015.rickandmorty.di

import com.ralex20015.rickandmorty.data.FavoritesRepositoryImpl
import com.ralex20015.rickandmorty.domain.repository.FavoritesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FavoritesRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindFavoriteRepositoryModule(impl: FavoritesRepositoryImpl): FavoritesRepository
}