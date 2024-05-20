package com.example.noteapps

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapps.db.NoteDao
import com.example.noteapps.db.NoteDatabase
import com.example.noteapps.viewmodel.NoteViewModel


class ViewModelFactory private constructor(
    private val noteDao: NoteDao,
) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    NoteDatabase.getInstance(context).noteDao
                )
            }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(NoteViewModel::class.java) -> {
                NoteViewModel(noteDao) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}