package com.ralex20015.rickandmorty.data.mapper

import com.ralex20015.rickandmorty.data.model.CharacterDto
import com.ralex20015.rickandmorty.data.model.LocationDto
import com.ralex20015.rickandmorty.data.model.OriginDto
import com.ralex20015.rickandmorty.domain.Gender
import com.ralex20015.rickandmorty.domain.Specie
import com.ralex20015.rickandmorty.domain.Status
import org.junit.Test
import org.junit.Assert.assertEquals

class CharacterMapperTest {
    @Test
    fun `toDomain maps dto to domain correctly`() {
        val dto = CharacterDto(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = OriginDto("Earth (C-137)", "asad"),
            location = LocationDto("Citadel of Rocks", "url"),
            image = "someImage",
            episodes = listOf(),
            url = "some_url",
            createdAt = "2017-11-04T18:48:46.250Z"
        )
        val domain = dto.toDomain()

        assertEquals(1, domain.id)
        assertEquals("Rick Sanchez", domain.name)
        assertEquals(Status.ALIVE, domain.lifeStatus)
        assertEquals(Gender.MALE, domain.gender)
        assertEquals(Specie.HUMAN, domain.specie)
    }

    @Test
    fun `toDomain maps alien female correctly`() {
        // 1. GIVEN - Una Alien Mujer (ej. Ma-Sha)
        val dto = CharacterDto(
            id = 2,
            name = "Ma-Sha",
            gender = "Female",
            species = "Alien",
            status = "Alive",
            type = "",
            origin = OriginDto("asdas", ""),
            location = LocationDto("asdas", "asda"),
            image = "a",
            episodes = listOf(),
            url = "",
            createdAt = "",
        )

        // 2. WHEN
        val domain = dto.toDomain()

        // 3. THEN
        assertEquals(Gender.FEMALE, domain.gender)
        assertEquals(Specie.ALIEN, domain.specie)
    }
}