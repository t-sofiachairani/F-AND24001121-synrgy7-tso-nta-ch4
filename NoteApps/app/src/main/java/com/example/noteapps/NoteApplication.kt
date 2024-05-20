package com.example.noteapps

import android.app.Application

import com.example.noteapps.db.NoteDatabase

class NoteApplication : Application() {
    val database by lazy { NoteDatabase.getInstance(this) }

    override fun onCreate() {
        super.onCreate()
    }

}