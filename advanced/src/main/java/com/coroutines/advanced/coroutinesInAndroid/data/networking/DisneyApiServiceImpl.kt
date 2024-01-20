package com.raywenderlich.android.disneyexplorer.data.networking

import com.coroutines.advanced.coroutineInUiLayer.data.networking.DisneyApi
import com.coroutines.advanced.coroutineInUiLayer.data.networking.DisneyApiService
import com.raywenderlich.android.disneyexplorer.data.model.CharactersResponse
import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter
import com.coroutines.advanced.coroutinesInAndroid.di.DependencyHolder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisneyApiServiceImpl(private val disneyApi: DisneyApi) : DisneyApiService {

  override fun getCharactersAsync(
    onSuccess: (List<DisneyCharacter>) -> Unit,
    onError: (Throwable) -> Unit
  ) {
    // Make an asynchronous request
    disneyApi.getCharacters().enqueue(object : Callback<CharactersResponse> {
      override fun onResponse(
        call: Call<CharactersResponse>,
        response: Response<CharactersResponse>
      ) {
        // Invoke onSuccess lambda when the results are ready
        response.body()?.data?.let(onSuccess)
      }

      override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
        // Invoke onError if an error happens
        onError(t)
      }
    })
  }

  override fun getDisneyCharacters(): List<DisneyCharacter> {

    // Initiate the request
    val response = DependencyHolder.disneyApi.getCharacters().execute()

    // Process the response
    return response.body()?.data ?: emptyList()
  }

  // TODO: Change the Dispatcher here
  override suspend fun getCharactersSuspend() = disneyApi.characters().data

  override suspend fun getCharactersResponse(): List<DisneyCharacter> {
    return emptyList()
  }
}

