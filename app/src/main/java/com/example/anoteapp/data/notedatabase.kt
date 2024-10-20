package com.example.anoteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.anoteapp.util.UUIDcoverter
import com.example.anoteapp.util.dataconverter


@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(dataconverter::class)
abstract class notedatabase: RoomDatabase() {
    abstract fun noteDao(): NoteBaseDao
}
