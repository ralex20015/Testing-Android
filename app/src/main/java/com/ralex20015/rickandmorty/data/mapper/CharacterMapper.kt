package com.ralex20015.rickandmorty.data.mapper

import com.ralex20015.rickandmorty.data.model.CharacterDto
import com.ralex20015.rickandmorty.domain.Character
import com.ralex20015.rickandmorty.domain.Gender
import com.ralex20015.rickandmorty.domain.Status
import com.ralex20015.rickandmorty.domain.Specie

fun CharacterDto.toDomain(): Character {
    return Character(
        this.id,
        this.name,
        this.image,
        lifeStatus = mapLifeStatus(this.status),
        gender = mapGender(this.gender),
        specie = mapSpecie(species)
    )
}

private fun mapLifeStatus(status: String): Status {
    return when (status) {
        "Alive" -> Status.ALIVE
        "Dead" -> Status.DEAD
        else -> Status.UNKNOWN
    }
}

private fun mapGender(gender: String): Gender {
    return when(gender) {
        "Male" -> Gender.MALE
        "Female" -> Gender.FEMALE
        else -> Gender.OTHER
    }
}

private fun mapSpecie(specie: String): Specie {
    return when(specie) {
        "Alien"-> Specie.ALIEN
        "Human" -> Specie.HUMAN
        else -> Specie.UNKNOWN
    }
}