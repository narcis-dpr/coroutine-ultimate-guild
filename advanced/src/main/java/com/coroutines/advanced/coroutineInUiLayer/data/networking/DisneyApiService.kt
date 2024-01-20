
package com.coroutines.advanced.coroutineInUiLayer.data.networking

import com.coroutines.advanced.coroutinesInAndroid.data.model.CharactersResponse

class DisneyApiService(private val disneyApi: DisneyApi) {

    suspend fun getCharacters(): Result<CharactersResponse> =
        kotlin.runCatching {
            disneyApi.getCharacters()
        }
}
