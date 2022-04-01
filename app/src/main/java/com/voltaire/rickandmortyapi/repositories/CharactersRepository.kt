package com.voltaire.rickandmortyapi.repositories

import com.voltaire.rickandmortyapi.api.RetrofitService
import com.voltaire.rickandmortyapi.model.CharacterList

class CharactersRepository(private val retrofitService: RetrofitService) {

    suspend fun getCharacters(page : Int): CharacterList {
        return retrofitService.getCharacters(page)
    }


}