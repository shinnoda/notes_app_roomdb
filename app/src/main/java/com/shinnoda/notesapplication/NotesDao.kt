package com.shinnoda.notesapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query ("SELECT * FROM notesTable ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}