package com.ralex20015.rickandmorty.di

import com.ralex20015.rickandmorty.data.CharacterRepositoryImpl
import com.ralex20015.rickandmorty.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCharacterRepositoryModule(impl: CharacterRepositoryImpl): CharacterRepository
}