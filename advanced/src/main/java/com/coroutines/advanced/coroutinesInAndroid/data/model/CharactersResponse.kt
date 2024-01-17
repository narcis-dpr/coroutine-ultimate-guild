package com.raywenderlich.android.disneyexplorer.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(val data: List<DisneyCharacter>)
