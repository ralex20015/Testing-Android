package com.ralex20015.rickandmorty.data

import com.ralex20015.rickandmorty.domain.Character
import com.ralex20015.rickandmorty.domain.repository.FavoritesRepository
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(

): FavoritesRepository{
    override fun setAsFavorite(id: Int): Boolean {
        return true
    }

    override suspend fun getFavoriteIds(): Set<Int> {
        return setOf()
    }


}