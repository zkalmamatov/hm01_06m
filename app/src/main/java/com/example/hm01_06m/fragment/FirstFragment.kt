package com.example.hm01_06m.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hm01_06m.adapter.CharacterListAdapter
import com.example.hm01_06m.databinding.FragmentFirstBinding
import com.example.hm01_06m.resource.Resource
import com.example.hm01_06m.viewModel.FragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val characAdapter by lazy {
        CharacterListAdapter()
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[FragmentViewModel::class.java]
    }
    private val binding by lazy {
        FragmentFirstBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()

        viewModel.fetchCharacters().observe(this) { res ->
            binding.progresBar.isVisible = res is Resource.Loading
            when (res) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), res.message, Toast.LENGTH_SHORT).show()
                }

                is Resource.Success -> {
                    characAdapter.submitList(res.data)
                }

                else -> {}
            }
        }
    }

    private fun setUpRecyclerView() = with(binding.rvApp) {
        adapter = characAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}