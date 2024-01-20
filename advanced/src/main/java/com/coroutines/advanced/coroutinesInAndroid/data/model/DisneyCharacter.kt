package com.coroutines.advanced.coroutinesInAndroid.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "character")
@Serializable
data class DisneyCharacter(
    @SerialName("_id") @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
)
