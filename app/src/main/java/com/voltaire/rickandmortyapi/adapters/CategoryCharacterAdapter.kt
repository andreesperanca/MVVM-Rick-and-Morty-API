package com.voltaire.rickandmortyapi.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.voltaire.rickandmortyapi.R
import com.voltaire.rickandmortyapi.model.Character
import com.voltaire.rickandmortyapi.model.CharacterCategory


class CategoryCharacterAdapter :
    RecyclerView.Adapter<CategoryCharacterAdapter.CharacterCategoryHolder>() {

    private val characters = listOf(
        Character("Andre", 2),
        Character("Pedor", 2),
        Character("sdasd", 2),
        Character("Andraasd", 2),
        Character("Andresda", 2),
        Character("Andreasd", 2),
        Character("Andreadsad", 2)
    )

    val categories = listOf(
        CharacterCategory("Vivo", 1, characters),
        CharacterCategory("Morto", 1, characters),
        CharacterCategory("Morto", 1, characters),
        CharacterCategory("Morto", 1, characters),
        CharacterCategory("Morto", 1, characters),
        CharacterCategory("Maluco", 1, characters)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterCategoryHolder {
        return CharacterCategoryHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterCategoryHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CharacterCategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val innerRecyclerView: RecyclerView = itemView.findViewById(R.id.innerRecyclerView)
        private val txtCategoryName: TextView = itemView.findViewById(R.id.txt_category)

        fun bind(categories: CharacterCategory) {
            innerRecyclerView.adapter = CharacterAdapter(categories.characters)
            innerRecyclerView.layoutManager =
                LinearLayoutManager(itemView.context, HORIZONTAL, false)
            txtCategoryName.text = categories.name
        }
    }
}

