package com.example.anoteapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anoteapp.NoteApp
import com.example.anoteapp.Screen.Feedback
import com.example.anoteapp.Screen.NoteAppPreview
import com.example.anoteapp.Screen.NoteAppPreviewPreview
import com.example.anoteapp.Screen.Noteviewmodel
import com.example.anoteapp.Screen.Top
import com.example.anoteapp.Screen.allNotes
import java.util.UUID

@Composable
fun Navigation() {
    val noteViewModel: Noteviewmodel = viewModel()
    val navController = rememberNavController()
    val noteList = noteViewModel.noteList.collectAsState().value
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            NoteAppPreview(navController)
        }
        composable("note") {
            Top(
                navController = navController,
                notes = noteList,
                onAddNote = { noteViewModel.addNote(it) },
                onUpdateNote = { noteViewModel.updateNote(it)}
            )
        }
        composable("editNote/{noteId}") { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")?.let { UUID.fromString(it) }
            val noteToEdit = noteList.find { it.id == noteId }
            noteToEdit?.let {
                Top(
                    navController = navController,
                    notes = noteList,
                    onAddNote = { noteViewModel.addNote(it) },
                    onUpdateNote = { noteViewModel.updateNote(it) },
                    noteToEdit = it
                )
            }
        }
        composable("allNotes") {
            allNotes(navController, notes = noteList, onRemovenote = { noteViewModel.deleteNote(it) })
        }
        composable("app") {
            NoteAppPreviewPreview(navController)
        }
        composable("support") {
            Feedback(navController)
        }
    }
}
