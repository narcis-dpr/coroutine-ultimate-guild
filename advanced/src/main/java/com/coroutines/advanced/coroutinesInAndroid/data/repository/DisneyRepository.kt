package com.coroutines.advanced.coroutinesInAndroid.data.repository

import com.coroutines.advanced.coroutinesInAndroid.data.model.DisneyCharacter
import kotlinx.coroutines.flow.Flow

interface DisneyRepository {
    suspend fun getDisneyCharacters(): List<DisneyCharacter>
    fun disneyCharacterFlow(): Flow<List<DisneyCharacter>>
}
