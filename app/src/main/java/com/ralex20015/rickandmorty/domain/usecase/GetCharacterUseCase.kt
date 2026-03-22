package com.ralex20015.rickandmorty.domain.usecase

import com.ralex20015.rickandmorty.domain.CharacterPage
import com.ralex20015.rickandmorty.domain.repository.CharacterRepository
import com.ralex20015.rickandmorty.domain.repository.FavoritesRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetCharactersWithFavoritesUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val favoritesRepository: FavoritesRepository,
) {

    suspend operator fun invoke(page: Int): Result<CharacterPage> = coroutineScope {

        val result = async {  characterRepository.getCharacters(page) }
        val favoritesIds = async {  favoritesRepository.getFavoriteIds() }
        if(result.await().isSuccess) {
            val pageData = result.await().getOrNull()!!
            val charactersWithFavorites = pageData.characters.map { character -> character.copy(isFavorite = favoritesIds.await().contains(character.id)) }
            return@coroutineScope Result.success(pageData.copy(characters = charactersWithFavorites))
        }else {
            return@coroutineScope Result.failure(Exception("A"))
        }
    }
}