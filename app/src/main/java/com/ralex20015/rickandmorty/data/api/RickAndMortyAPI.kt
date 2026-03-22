package com.ralex20015.rickandmorty.data.api

import com.ralex20015.rickandmorty.data.model.ResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyAPI {

    @GET(ApiConstants.CHARACTERS_ENDPOINT)
    suspend fun getCharacters(
        @Query("page") page: Int,
    ): Response<ResponseApi>

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}