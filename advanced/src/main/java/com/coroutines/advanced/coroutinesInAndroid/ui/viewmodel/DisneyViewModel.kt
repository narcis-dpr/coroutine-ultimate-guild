package com.coroutines.advanced.coroutinesInAndroid.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.coroutines.advanced.coroutinesInAndroid.data.model.DisneyCharacter
import com.coroutines.advanced.coroutinesInAndroid.data.repository.DisneyRepository
import com.coroutines.advanced.coroutinesInAndroid.di.DependencyHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DisneyViewModel : ViewModel() {
    private val disneyRepo: DisneyRepository by lazy { DependencyHolder.disneyRepository }
    private val _uiState = MutableStateFlow(emptyList<DisneyCharacter>())
    val uiState: StateFlow<List<DisneyCharacter>>
        get() = _uiState

    init {
        getDisneyCharacters()
    }

    private fun getDisneyCharacters() {
        // Add the implementation here
    }
}
