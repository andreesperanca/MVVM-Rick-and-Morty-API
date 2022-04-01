package com.voltaire.rickandmortyapi.ui.episodes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.voltaire.rickandmortyapi.R
import com.voltaire.rickandmortyapi.databinding.FragmentEpisodesBinding


class Episodes : Fragment() {

    private lateinit var binding : FragmentEpisodesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.teste.setOnClickListener {
            findNavController().navigate(R.id.action_characters_to_charactersDetailsFragment)
        }
    }
}