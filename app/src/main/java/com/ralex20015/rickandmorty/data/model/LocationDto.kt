package com.ralex20015.rickandmorty.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val name: String,
    val url: String,
)
