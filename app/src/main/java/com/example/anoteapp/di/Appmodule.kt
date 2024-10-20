package com.example.anoteapp.di

import android.content.Context
import androidx.room.Room
import com.example.anoteapp.data.NoteBaseDao
import com.example.anoteapp.data.notedatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: notedatabase): NoteBaseDao =
        noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): notedatabase =
        Room.databaseBuilder(
            context,
            notedatabase::class.java,
            "notes_db"
        ).fallbackToDestructiveMigration()
            .build()
}
