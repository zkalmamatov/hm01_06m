package com.example.hm01_06m.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    fun fetchCharacter(): Response<List<Character>>

    @GET("character/{id}")
    fun fetchCharacterById(@Path("id") id: Int): Response<Character>
}