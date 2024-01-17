package com.coroutines.advanced.coroutinesInAndroid.ui.adapter.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.coroutines.advanced.databinding.ListItemCharacterBinding
import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter

class CharacterViewHolder(private val binding: ListItemCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(disneyCharacter: DisneyCharacter) = with(binding) {
        characterImage.load(disneyCharacter.imageUrl)
        characterName.text = disneyCharacter.name
    }

    companion object {
        fun create(parent: ViewGroup): CharacterViewHolder {
            val binding = ListItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
            return CharacterViewHolder(binding)
        }
    }
}
