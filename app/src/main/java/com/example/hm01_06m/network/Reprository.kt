package com.example.hm01_06m.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hm01_06m.api.ApiService
import com.example.hm01_06m.models.Character
import com.example.hm01_06m.resource.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Reprository @Inject constructor(

    private val api: ApiService,
    private val coroutineScope: CoroutineScope
) {

    fun fetchCharacters(): LiveData<Resource<List<Character>>> {
        val data = MutableLiveData<Resource<List<Character>>>()
        data.postValue(Resource.Loading())

        coroutineScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    api.fetchCharacter()
                }
                if (response.isSuccessful && response.body() != null) {
                    data.postValue(Resource.Error("Error: ${response.code()}"))
                }
            } catch (t: Throwable) {
                data.postValue(Resource.Error(t.localizedMessage ?: "Unknown Error"))
            }
        }
        return data
    }
}