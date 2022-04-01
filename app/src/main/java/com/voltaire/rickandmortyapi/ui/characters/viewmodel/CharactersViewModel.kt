package com.voltaire.rickandmortyapi.ui.characters.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voltaire.rickandmortyapi.model.Character
import com.voltaire.rickandmortyapi.repositories.CharactersRepository
import kotlinx.coroutines.launch



class CharactersViewModel constructor(private val repository: CharactersRepository) : ViewModel() {

    var listCharacters = MutableLiveData<List<Character>>()
    var listCharacters2 = MutableLiveData<List<Character>>()
    var listGrande = MutableLiveData<List<Character>>()



    fun getCharacters  (page : Int, page2 : Int) {
        viewModelScope.launch {
            val characters = repository.getCharacters(page)
            val characters2 = repository.getCharacters(page2)

            listCharacters.value = characters.results + characters2.results
        }
    }
}
