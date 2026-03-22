package com.ralex20015.rickandmorty.data.model

import kotlinx.serialization.Serializable

@Serializable
data class InfoDto(
    val count: Int,
    val pages: Int,
)
