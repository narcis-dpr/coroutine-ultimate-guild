
package com.coroutines.advanced.coroutineInUiLayer.data.networking

import com.raywenderlich.android.disneyexplorer.data.model.CharactersResponse
import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisneyApiService(private val disneyApi: DisneyApi) {

    fun getCharacters(
        onError: (Throwable) -> Unit,
        onSuccess: (List<DisneyCharacter>) -> Unit,
    ) {
        // Make an asynchronous request
        disneyApi.getCharacters().enqueue(object : Callback<CharactersResponse> {
            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>,
            ) {
                // Invoke onSuccess lambda when the results are ready
                val data = response.body()
                if (data == null) {
                    onError(Throwable("No response"))
                } else {
                    onSuccess(data.data)
                }
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                // Invoke onError if an error happens
                onError(t)
            }
        })
    }

    fun getDisneyCharacters(): List<DisneyCharacter> {
        // Initiate the request
        val response = disneyApi.getCharacters().execute()

        // Process the response
        return response.body()?.data ?: emptyList()
    }
}
