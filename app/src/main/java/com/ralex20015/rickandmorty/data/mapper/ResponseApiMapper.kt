package com.ralex20015.rickandmorty.data.mapper

import com.ralex20015.rickandmorty.data.model.ResponseApi
import com.ralex20015.rickandmorty.domain.CharacterPage

fun ResponseApi.toDomain(currentPage: Int): CharacterPage {
    return CharacterPage(
        characters = this.characters.map { it.toDomain() },
        totalPages = this.info.pages,
        hasNextPage = currentPage < this.info.pages
    )
}