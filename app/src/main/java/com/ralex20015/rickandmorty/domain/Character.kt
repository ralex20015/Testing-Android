package com.ralex20015.rickandmorty.domain

data class Character(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val lifeStatus: Status,
    val gender: Gender,
    val specie: Specie,
    val isFavorite: Boolean = false,
)