package com.raywenderlich.android.disneyexplorer.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter

@Database(entities = [DisneyCharacter::class], version = 1, exportSchema = false)
abstract class DisneyDatabase : RoomDatabase() {
  abstract fun characterDao(): CharacterDao
}
