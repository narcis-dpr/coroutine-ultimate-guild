package com.raywenderlich.android.disneyexplorer.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.raywenderlich.android.disneyexplorer.data.model.DisneyCharacter

@Dao
interface CharacterDao {

  @Insert
  fun saveCharacters(characters: List<DisneyCharacter>)

  // TODO: Add suspend modifier to the function and compare the results (chapter 17)
  @Query("SELECT * FROM character")
  fun getCharacters(): List<DisneyCharacter>

// TODO: Add a function which returns flow of data (chapter 17)

// TODO: Add a function which returns results wrapped in LiveData (chapter 18)

}
