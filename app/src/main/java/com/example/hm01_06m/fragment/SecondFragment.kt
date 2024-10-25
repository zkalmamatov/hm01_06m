package com.example.hm01_06m.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.hm01_06m.R
import com.example.hm01_06m.databinding.FragmentSecondBinding
import com.example.hm01_06m.models.Character
import com.example.hm01_06m.viewModel.SecondViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private val secondViewModel: SecondViewModel by viewModel()
    private val binding by lazy { FragmentSecondBinding.inflate(layoutInflater) }
    private var characterId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        characterId = arguments?.getInt("characterId")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterId?.let { id ->

            secondViewModel.getCharacterById(id).observe(viewLifecycleOwner, Observer { character ->
                character?.let {
                    displayCharaterInfo(it)
                }
            })
        }
    }

    private fun displayCharaterInfo(character: Character) {
        binding.characterName.text = character.name
        binding.characterStatus.text = character.status
        binding.characterGender.text = "Gender: ${character.gender}"
        binding.characterLocation.text = "Last known location: ${character.location.name}"
        binding.characterFirstSeen.text = "First seen in: ${character.episode.joinToString()}"

        Glide.with(this)
            .load(character.image)
            .placeholder(R.drawable.placeholder_image)
            .into(binding.characterImage)
    }
}