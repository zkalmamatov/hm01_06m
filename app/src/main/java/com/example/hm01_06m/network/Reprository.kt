package com.example.hm01_06m.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hm01_06m.api.ApiService
import com.example.hm01_06m.models.Character
import com.example.hm01_06m.resource.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Reprository @Inject constructor(

    private val api: ApiService

) {

    fun fetchCharacters(): LiveData<Resource<List<Character>>> {
        val data = MutableLiveData<Resource<List<Character>>>()
        data.postValue(Resource.Loading())
        api.fetchCharacter().enqueue(object : Callback<List<Character>> {
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    data.postValue(Resource.Success(response.body()!!))
                }
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                data.postValue(Resource.Error(t.localizedMessage ?: "Unknown Error"))
            }
        })
        return data
    }
}