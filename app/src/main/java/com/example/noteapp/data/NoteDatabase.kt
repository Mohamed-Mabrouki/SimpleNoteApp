package com.example.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteapp.model.Note
import com.example.noteapp.util.Converter

@Database(entities = [Note::class], version = 2, exportSchema = false)


@TypeConverters(Converter::class)
abstract class NoteDatabase : RoomDatabase() {
	abstract fun noteDao() : NoteDatabaseDao
}