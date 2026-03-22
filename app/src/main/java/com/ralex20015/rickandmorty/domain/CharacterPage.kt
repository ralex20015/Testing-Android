package com.ralex20015.rickandmorty.domain


data class CharacterPage(
    val characters: List<Character>,
    val totalPages: Int,
    val hasNextPage: Boolean
)