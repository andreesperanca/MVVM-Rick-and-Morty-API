package com.voltaire.rickandmortyapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.voltaire.rickandmortyapi.adapters.CategoryCharacterAdapter
import com.voltaire.rickandmortyapi.databinding.FragmentCharactersBinding

class Characters : Fragment() {

    private lateinit var binding : FragmentCharactersBinding
    private lateinit var adapter : CategoryCharacterAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.charactersRecyclerView
        adapter = CategoryCharacterAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())



    }
}