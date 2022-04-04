package com.voltaire.rickandmortyapi.repositories

import com.voltaire.rickandmortyapi.api.RetrofitService
import com.voltaire.rickandmortyapi.model.Character
import com.voltaire.rickandmortyapi.model.CharacterList

class CharactersRepository(private val retrofitService: RetrofitService) {

    suspend fun getCharacters(page : Int): CharacterList {
        return retrofitService.getCharacters(page)
    }
    suspend fun getCharactersStatusGender(status : String, gender: String, page:Int) : CharacterList{
        return retrofitService.getCharactersStatusGender(status, gender, page)
    }
    suspend fun getCharacterStatus (status : String, page : Int) : CharacterList {
        return retrofitService.getCharacterStatus(status , page)
    }
    suspend fun getCharacterGender (gender : String, page : Int) : CharacterList {
        return retrofitService.getCharacterGender(gender , page)
    }
    suspend fun getCharacterName (name : String) : CharacterList {
        return retrofitService.getCharacterName(name)

    }
}