package com.raywenderlich.android.disneyexplorer.data.repository

import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter
import kotlinx.coroutines.flow.Flow

interface DisneyRepository {
  suspend fun getDisneyCharacters(): List<DisneyCharacter>
  fun disneyCharacterFlow(): Flow<List<DisneyCharacter>>
}
