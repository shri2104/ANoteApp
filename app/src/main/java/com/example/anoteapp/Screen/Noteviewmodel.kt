package com.example.anoteapp.Screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.anoteapp.data.Note
import com.example.anoteapp.noterepo.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class Noteviewmodel @Inject constructor(private val repo: NoteRepo): ViewModel(){
       private val _notelist= MutableStateFlow<List<Note>>(emptyList())
       val noteList = _notelist.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllNotes().distinctUntilChanged()
                .collect { listOfNotes ->
                    if (listOfNotes.isNullOrEmpty()) {
                        Log.d("Empty", ": Empty list")
                    } else {
                        _notelist.value = listOfNotes
                    }
                }
        }
    }
     fun addNote(note:Note)=viewModelScope.launch {repo.addNote(note)}
     fun deleteNote(note:Note)=viewModelScope.launch {repo.deleteNote(note)}
     fun updateNote(note:Note)=viewModelScope.launch {repo.updateNote(note)}

}