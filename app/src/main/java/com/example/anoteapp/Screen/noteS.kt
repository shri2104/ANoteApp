package com.example.anoteapp.Screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.anoteapp.component.InputF
import com.example.anoteapp.data.Note
import com.example.anoteapp.util.formatdate
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Top(
    navController: NavController,
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onUpdateNote: (Note) -> Unit,
    noteToEdit: Note? = null
) {
    val pinkColor = Color(0xFFFFA500)
    val veryLightPink = Color(0xFFFFDAB9)
    var title by remember { mutableStateOf(noteToEdit?.title ?: "") }
    var description by remember { mutableStateOf(noteToEdit?.description ?: "") }
    val context = LocalContext.current

    Surface(
        color = veryLightPink,
        modifier = Modifier.fillMaxSize(),
        shadowElevation = 12.dp
    ) {
        Column(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth()
        ) {
            Surface(shadowElevation = 12.dp) {
                TopAppBar(
                    title = { Text("Notes") },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = pinkColor)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InputF(
                    text = title,
                    label = "Title",
                    onTextChange = {
                        if (it.all { it.isLetter() || it.isWhitespace() }) title = it
                    },
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.padding(top = 9.dp, bottom = 10.dp)
                )
                InputF(
                    text = description,
                    label = "Add a Note",
                    onTextChange = { description = it },
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.padding(top = 9.dp, bottom = 10.dp)
                )
                Button(
                    onClick = {
                        if (title.isNotEmpty() && description.isNotEmpty()) {
                            val note = Note(
                                id = noteToEdit?.id ?: UUID.randomUUID(),
                                title = title,
                                description = description,
                                entryDate = noteToEdit?.entryDate ?: Date()
                            )
                            if (noteToEdit != null) {
                                onUpdateNote(note)
                                Toast.makeText(context, "Note Updated", Toast.LENGTH_SHORT).show()
                            } else {
                                onAddNote(note)
                                Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                            }
                            description = ""
                            title = ""
                            navController.navigate("allNotes")
                        }
                    },
                    elevation = ButtonDefaults.buttonElevation(5.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = pinkColor)
                ) {
                    Text(text = if (noteToEdit != null) "Update" else "Save")
                }
                Divider(modifier = Modifier.padding(10.dp))
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Button(
                        onClick = { navController.navigate("allNotes") },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = pinkColor),
                        elevation = ButtonDefaults.buttonElevation(5.dp)
                    ) {
                        Text(text = "Notes")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Noterow(
    navController: NavController,
    modifier: Modifier = Modifier,
    note: Note,
    onClicked: (Note) -> Unit
) {
    val pinkColor = Color(0xFFFFA500)
    val veryLightPink = Color(0xFFFFDAB9)

    Surface(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(topEnd = 33.dp)),
        shadowElevation = 15.dp,
        color = veryLightPink
    ) {
        Column(modifier = modifier.padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = { navController.navigate("editNote/${note.id}") }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit", tint = pinkColor)
                }
                IconButton(onClick = { onClicked(note) }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete", tint = pinkColor)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = note.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = formatdate(note.entryDate.time),
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}