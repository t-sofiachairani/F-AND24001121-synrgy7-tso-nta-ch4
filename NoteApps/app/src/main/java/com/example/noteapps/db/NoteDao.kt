package com.example.noteapps.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert()
    abstract fun createNote(note: Note)

    @Query("SELECT * FROM `note-table-sofi`")
    abstract fun readAllNotes() : LiveData<List<Note>>

    @Query("SELECT * FROM `note-table-sofi` WHERE id=:id")
    abstract fun getNoteByID(id:Long) : Note

    @Update()
    abstract fun updateNote(note:Note) : Int

    @Delete()
    abstract fun deleteNote(note:Note) : Int

}