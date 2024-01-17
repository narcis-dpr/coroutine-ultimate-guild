package com.coroutines.advanced.coroutinesInAndroid.ui.adapter.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter

class DisneyAdapter : RecyclerView.Adapter<CharacterViewHolder>() {
  private val data: MutableList<DisneyCharacter> = mutableListOf()

  fun setData(characters: List<DisneyCharacter>) {
    data.clear()
    data.addAll(characters)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
    return CharacterViewHolder.create(parent)
  }

  override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
    holder.bind(data[position])
  }

  override fun getItemCount() = data.size
}
