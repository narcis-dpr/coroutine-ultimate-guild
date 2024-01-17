package com.raywenderlich.android.disneyexplorer.data.networking

import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter
import retrofit2.Response

interface DisneyApiService {
  fun getCharactersAsync(onSuccess: (List<DisneyCharacter>) -> Unit, onError: (Throwable) -> Unit)

  fun getDisneyCharacters(): List<DisneyCharacter>

  suspend fun getCharactersSuspend(): List<DisneyCharacter>

  suspend fun getCharactersResponse(): List<DisneyCharacter>
}
