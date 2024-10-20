package com.example.anoteapp.noterepo

import com.example.anoteapp.data.Note
import com.example.anoteapp.data.NoteBaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepo @Inject constructor(private val noteBaseDao: NoteBaseDao) {
    suspend fun addNote(note: Note) = noteBaseDao.insert(note)
    suspend fun updateNote(note: Note) = noteBaseDao.update(note)
    suspend fun  deleteNote(note: Note) = noteBaseDao.deleteNote(note)
    suspend fun deleteAllNotes() = noteBaseDao.deleteAll()
    fun getAllNotes(): Flow<List<Note>> = noteBaseDao.getNotes()
        .flowOn(Dispatchers.IO)
        .conflate()
}