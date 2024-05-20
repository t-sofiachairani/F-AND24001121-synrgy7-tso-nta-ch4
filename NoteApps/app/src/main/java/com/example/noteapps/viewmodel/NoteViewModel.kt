package com.example.noteapps.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapps.db.Note
import com.example.noteapps.db.NoteDao

class NoteViewModel(val noteDao:NoteDao) : ViewModel(){

    private val _notes: MutableLiveData<List<Note>> = MutableLiveData(emptyList())
    val notes get() = _notes

    fun addNote(note: Note) {
        noteDao.createNote(note)
    }

    fun getNotes() = noteDao.readAllNotes()

    fun getNoteByID(idNote:Long) = noteDao.getNoteByID(idNote)

    fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
        getNotes()
    }

    fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }


    fun fakeDeleteDao(idNote: Long) {
        val listbaru = mutableListOf<Note>()
        val listlama = _notes.value
        listlama?.forEach {
            if (it.id != idNote) {
                listbaru.add(it)
            }
        }
        _notes.value = listbaru
    }


}