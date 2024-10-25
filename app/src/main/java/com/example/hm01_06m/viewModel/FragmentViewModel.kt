package com.example.hm01_06m.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hm01_06m.network.Reprository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentViewModel @Inject constructor(
    private val reprository: Reprository
) : ViewModel() {

    fun fetchCharacters() = reprository.fetchCharacters()
}