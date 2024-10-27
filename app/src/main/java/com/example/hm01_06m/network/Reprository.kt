package com.example.hm01_06m.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hm01_06m.BaseRepository
import com.example.hm01_06m.api.ApiService
import com.example.hm01_06m.models.Character

class Reprository(private val api: ApiService) : BaseRepository() {

    suspend fun fetchCharacters(): LiveData<List<Character>?> = MutableLiveData<List<Character>?>().also {
        it.postValue(makeApiCall { api.fetchCharacter() }.value?.characters)
    }
}