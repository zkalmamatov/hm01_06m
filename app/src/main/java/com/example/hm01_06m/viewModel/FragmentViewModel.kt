package com.example.hm01_06m.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hm01_06m.models.Character
import com.example.hm01_06m.network.Reprository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class FragmentViewModel(
    private val reprository: Reprository
) : ViewModel() {

    val characters: LiveData<List<Character>> = reprository.fetchCharacters()
}