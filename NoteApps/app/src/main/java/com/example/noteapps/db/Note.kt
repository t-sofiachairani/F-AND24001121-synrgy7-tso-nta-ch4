package com.example.noteapps.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "note-table-sofi")
@Parcelize
data class Note(

    @PrimaryKey(autoGenerate = true)
    val id:Long = 0L,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "note")
    val note: String?

) : Parcelable
