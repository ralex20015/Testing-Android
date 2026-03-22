package com.ralex20015.rickandmorty.data

import com.ralex20015.rickandmorty.data.api.RickAndMortyAPI
import com.ralex20015.rickandmorty.data.mapper.toDomain
import com.ralex20015.rickandmorty.domain.Character
import com.ralex20015.rickandmorty.domain.CharacterPage
import com.ralex20015.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyAPI
) : CharacterRepository {
    override suspend fun getCharacters(page: Int): Result<CharacterPage> {
        try {
            val result = api.getCharacters(page)
            if(result.isSuccessful){
                val responseBody = result.body() ?: throw Exception("Body is malformed")
                val characters = responseBody.toDomain(page)
                return Result.success(characters)
            }else {
               return Result.failure(Exception("Result failed"))
            }
        }catch (e: Exception) {
            return Result.failure(e)
        }
    }
}