package com.voltaire.rickandmortyapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voltaire.rickandmortyapi.R
import com.voltaire.rickandmortyapi.model.Character


class CharacterAdapter(characters: List<Character>) : RecyclerView.Adapter<TestViewHolder>() {

    private val characters = listOf(
        Character("Andre", 2),
        Character("Pedor", 2),
        Character("sdasd", 2),
        Character("Andraasd", 2),
        Character("Andresda", 2),
        Character("Andreasd", 2),
        Character("Andreadsad", 2)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}

class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(itemTest: Character) {
    }
}