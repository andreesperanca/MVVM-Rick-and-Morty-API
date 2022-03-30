package com.voltaire.rickandmortyapi.model

data class CharacterCategory(
    val name: String,
    var id: Int,
    var characters : List<Character>
)
