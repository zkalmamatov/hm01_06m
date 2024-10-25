package com.example.hm01_06m.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hm01_06m.network.Reprository2
import javax.inject.Inject

class SecondViewModel @Inject constructor
    (
    private val repository2: Reprository2
) : ViewModel() {

    fun getCharacters() = repository2.getCharacterById(0)
}