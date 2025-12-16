package com.ralex20015.rickandmorty.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseApi(
    val info: InfoDto,
    @SerialName("results") val characters: List<CharacterDto>
)