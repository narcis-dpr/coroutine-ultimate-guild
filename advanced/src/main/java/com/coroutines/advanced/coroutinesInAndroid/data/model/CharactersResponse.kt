package com.coroutines.advanced.coroutinesInAndroid.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(val data: List<DisneyCharacter>)
