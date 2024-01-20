package com.coroutines.advanced.coroutinesInAndroid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coroutines.advanced.coroutinesInAndroid.data.model.DisneyCharacter

@Database(entities = [DisneyCharacter::class], version = 1, exportSchema = false)
abstract class DisneyDatabase : RoomDatabase() {
  abstract fun characterDao(): CharacterDao
}
