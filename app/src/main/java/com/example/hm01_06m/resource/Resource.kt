package com.example.hm01_06m.resource

sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    class Error<T>(val message: String) : Resource<T>()
    class Success<T>(val data: T) : Resource<T>()
}