package com.example.hm01_06m.api

import com.example.hm01_06m.models.BaseResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    fun fetchCharacter(): Call<BaseResponse>

    @GET("character/{id}")
    fun fetchCharacterById(@Path("id") id: Int): Call<Character>
}