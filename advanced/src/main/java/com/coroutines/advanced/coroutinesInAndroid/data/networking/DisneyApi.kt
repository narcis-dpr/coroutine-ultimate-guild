package com.raywenderlich.android.disneyexplorer.data.networking

import com.raywenderlich.android.disneyexplorer.data.model.CharactersResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface DisneyApi {

  @GET("characters")
  fun getCharacters(): Call<CharactersResponse>

  @GET("characters")
  suspend fun characters(): CharactersResponse

  @GET("characters")
  suspend fun getCharactersResponse(): Response<CharactersResponse>
}
