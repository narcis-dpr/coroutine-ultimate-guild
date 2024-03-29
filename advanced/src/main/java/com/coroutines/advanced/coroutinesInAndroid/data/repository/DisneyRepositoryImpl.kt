package com.coroutines.advanced.coroutinesInAndroid.data.repository

import com.coroutines.advanced.coroutineInUiLayer.common.utiles.CoroutineContextProvider
import com.coroutines.advanced.coroutinesInAndroid.data.database.CharacterDao
import com.coroutines.advanced.coroutinesInAndroid.data.model.DisneyCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class DisneyRepositoryImpl(
//    private val apiService: DisneyApiService,
    private val characterDao: CharacterDao,
    private val coroutineContextProvider: CoroutineContextProvider,
) : DisneyRepository {
    override suspend fun getDisneyCharacters(): List<DisneyCharacter> {
        return withContext(coroutineContextProvider.ioDispatcher) {
//      val apiResponse = apiService.getCharactersSuspend()
//      characterDao.saveCharacters(apiResponse)
            characterDao.getCharacters()
        }
    }

    override fun disneyCharacterFlow(): Flow<List<DisneyCharacter>> {
        return flow {
//      val apiResponse = apiService.getCharactersSuspend()
//      characterDao.saveCharacters(apiResponse)
            emit(characterDao.getCharacters())
        }
    }
}
