
package com.coroutines.advanced.coroutineInUiLayer.data.networking

import com.raywenderlich.android.disneyexplorer.data.model.CharactersResponse
import retrofit2.http.GET

interface DisneyApi {

    @GET("characters")
    suspend fun getCharacters(): CharactersResponse
}
