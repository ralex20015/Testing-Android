package com.ralex20015.rickandmorty.domain.repository

import com.ralex20015.rickandmorty.domain.Character

interface FavoritesRepository {
    fun setAsFavorite(id: Int): Boolean
    suspend fun getFavoriteIds(): Set<Int>
}