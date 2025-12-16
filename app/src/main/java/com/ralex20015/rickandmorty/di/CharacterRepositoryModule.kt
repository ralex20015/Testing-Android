package com.ralex20015.rickandmorty.di

import com.ralex20015.rickandmorty.data.CharacterRepositoryImpl
import com.ralex20015.rickandmorty.domain.CharacterRepository
import dagger.Binds
import javax.inject.Singleton

abstract class CharacterRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCharacterRepositoryModule(impl: CharacterRepositoryImpl): CharacterRepository
}