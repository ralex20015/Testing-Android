package com.ralex20015.rickandmorty.data

import com.ralex20015.rickandmorty.domain.Character
import com.ralex20015.rickandmorty.domain.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(

) : CharacterRepository {
    override suspend fun getCharacters(): Result<List<Character>> {
        TODO("Not yet implemented")
    }
}