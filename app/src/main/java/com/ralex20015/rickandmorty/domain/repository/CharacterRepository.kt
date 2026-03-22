package com.ralex20015.rickandmorty.domain.repository

import com.ralex20015.rickandmorty.domain.CharacterPage

interface CharacterRepository {
    suspend fun getCharacters(page: Int): Result<CharacterPage>
}