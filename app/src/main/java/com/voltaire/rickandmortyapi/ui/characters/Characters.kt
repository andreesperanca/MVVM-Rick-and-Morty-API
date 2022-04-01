package com.voltaire.rickandmortyapi.ui.characters


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.voltaire.rickandmortyapi.adapters.CharactersAdapter
import com.voltaire.rickandmortyapi.api.RetrofitService
import com.voltaire.rickandmortyapi.databinding.FragmentCharactersBinding
import com.voltaire.rickandmortyapi.repositories.CharactersRepository
import com.voltaire.rickandmortyapi.ui.characters.viewmodel.CharactersViewModel
import com.voltaire.rickandmortyapi.ui.characters.viewmodel.CharactersViewModelFactory


class Characters : Fragment() {

    private val viewModel: CharactersViewModel by activityViewModels{CharactersViewModelFactory(
        CharactersRepository(RetrofitService.getInstance())
    )}

    private lateinit var binding: FragmentCharactersBinding
    private lateinit var adapter: CharactersAdapter
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

        viewModel.getCharacters(1,2)


        viewModel.listCharacters.observe(viewLifecycleOwner) {
            adapter.setCharacters(it)
        }

        recyclerView = binding.charactersRecyclerView
        adapter = CharactersAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)



    }
}

