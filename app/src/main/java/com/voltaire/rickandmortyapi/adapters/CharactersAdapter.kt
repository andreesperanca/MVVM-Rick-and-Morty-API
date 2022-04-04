package com.voltaire.rickandmortyapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.voltaire.rickandmortyapi.R
import com.voltaire.rickandmortyapi.model.Character
import com.voltaire.rickandmortyapi.ui.characters.CharactersFragmentDirections


class CharactersAdapter() : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    private var listCharacters = emptyList<Character>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(listCharacters[position])

        holder.itemView.setOnClickListener {
            val action = CharactersFragmentDirections.actionCharactersToCharactersDetailsFragment((listCharacters[position]))
            it.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    fun setCharacters (characters: List<Character>){
        listCharacters = characters
        notifyDataSetChanged()
    }

    class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txt_nameCharacters : TextView = itemView.findViewById(R.id.txt_nameCharacters)
        val imageCharacter : ImageView = itemView.findViewById(R.id.imageCharacter)

        fun bind(character: Character) {
            txt_nameCharacters.text = character.name
            Glide
                .with(itemView.context)
                .load(character.image)
                .centerCrop()
                .into(imageCharacter)
        }
    }
}