package com.example.hm01_06m.network

import androidx.lifecycle.LiveData
import com.example.hm01_06m.BaseRepository
import com.example.hm01_06m.api.ApiService

class Reprository2(private val api: ApiService) : BaseRepository() {

    suspend fun getCharacterById(id: Int): LiveData<Character?> {
        return makeApiCall { api.fetchCharacterById(id) }

    }
}
