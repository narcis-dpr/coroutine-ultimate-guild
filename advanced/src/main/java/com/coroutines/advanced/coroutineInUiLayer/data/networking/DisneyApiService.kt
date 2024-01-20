
package com.coroutines.advanced.coroutineInUiLayer.data.networking

import com.raywenderlich.android.disneyexplorer.data.model.CharactersResponse
import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DisneyApiService(private val disneyApi: DisneyApi) {

    suspend fun getCharacters(): Result<CharactersResponse> =
        withContext(Dispatchers.IO) {
            try {
                val data = disneyApi.getCharacters().execute().body()
                if (data == null) {
                    Result.failure(Throwable("No response"))
                } else {
                    Result.success(data)
                }
            } catch (error: Throwable) {
                Result.failure(error)
            }
        }

    fun getDisneyCharacters(): List<DisneyCharacter> {
        // Initiate the request
        val response = disneyApi.getCharacters().execute()

        // Process the response
        return response.body()?.data ?: emptyList()
    }
}
