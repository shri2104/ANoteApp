package com.example.anoteapp.data


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteBaseDao {
    @Query("SELECT * from notesTable")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * from notesTable where id=:id")
     suspend fun getNotebyId(id:String):Note

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insert(note:Note)

     @Update(onConflict = OnConflictStrategy.REPLACE)
     suspend fun update(note:Note)

     @Query("DELETE from notesTable")
     suspend fun deleteAll()

     @Delete
     suspend fun deleteNote(note:Note)

}
