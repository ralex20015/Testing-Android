package com.ralex20015.rickandmorty.domain

import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(): Result<List<Character>>
}