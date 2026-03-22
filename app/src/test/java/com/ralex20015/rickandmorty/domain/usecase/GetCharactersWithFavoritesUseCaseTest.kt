package com.ralex20015.rickandmorty.domain.usecase

import com.ralex20015.rickandmorty.domain.Character
import com.ralex20015.rickandmorty.domain.CharacterPage
import com.ralex20015.rickandmorty.domain.Gender
import com.ralex20015.rickandmorty.domain.Specie
import com.ralex20015.rickandmorty.domain.Status
import com.ralex20015.rickandmorty.domain.repository.CharacterRepository
import com.ralex20015.rickandmorty.domain.repository.FavoritesRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetCharactersWithFavoritesUseCaseTest {

    private lateinit var favoritesRepository: FavoritesRepository
    private lateinit var charactersRepository: CharacterRepository
    private lateinit var useCase: GetCharactersWithFavoritesUseCase

    @Before
    fun setUp() {
        favoritesRepository = mockk<FavoritesRepository>()
        charactersRepository = mockk()
        useCase = GetCharactersWithFavoritesUseCase(
            characterRepository = charactersRepository,
            favoritesRepository = favoritesRepository
        )
    }

    @Test
    fun whenHasFavorites_shouldUpdateCharacterPageWithFavorites() = runTest {
        val mockCharacters = listOf(
            Character(1, "Rick", "url", Status.ALIVE, Gender.MALE, Specie.HUMAN),
            Character(2, "BBBB", "url", Status.ALIVE, Gender.FEMALE, Specie.HUMAN),
            Character(3, "CCCC", "url", Status.ALIVE, Gender.MALE, Specie.ALIEN)
        )

        val characterPage = CharacterPage(mockCharacters, 10, true)

        val favoriteIds = setOf(1, 3)
        val page = 1

        coEvery { favoritesRepository.getFavoriteIds() } returns favoriteIds
        coEvery { charactersRepository.getCharacters(page) } returns Result.success(characterPage)
        val charactersPageWithFavorites = useCase(page)
        val listOfCharacters = charactersPageWithFavorites.getOrNull()!!.characters

        val isCharacter1Favorite = listOfCharacters[0].isFavorite
        val isCharacter2Favorite = listOfCharacters[1].isFavorite
        val isCharacter3Favorite  = listOfCharacters[2].isFavorite

        assertEquals(true, isCharacter1Favorite)
        assertEquals(false, isCharacter2Favorite)
        assertEquals(true, isCharacter3Favorite)
    }

}