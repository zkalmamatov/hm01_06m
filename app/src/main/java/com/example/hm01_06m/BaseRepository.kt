package com.example.hm01_06m

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class BaseRepository {

    protected suspend fun <T> makeApiCall(
        call: suspend () -> Response<T>
    ): MutableLiveData<T?> {
        val data = MutableLiveData<T?>()

        try {
            val response = withContext(Dispatchers.IO) { call() }
            if (response.isSuccessful) {
                data.postValue(response.body())
            } else {
                data.postValue(null)
            }
        } catch (e: Exception) {
            data.postValue(null)
        }
        return data
    }
}