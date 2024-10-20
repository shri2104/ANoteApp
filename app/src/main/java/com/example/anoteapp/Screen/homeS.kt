package com.example.anoteapp.Screen

import android.view.RoundedCorner
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.anoteapp.R
import androidx.compose.material3.ButtonElevation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAppPreview(navController: NavController) {
    val pinkColor = Color(0xFFFFA500)
    val veryLightPink = Color(0xFFFFDAB9)
    Surface(
        modifier = Modifier.fillMaxSize(),
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Surface(shadowElevation = 22.dp) {
                TopAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = pinkColor),
                    title = { Text(text = "Notes", color = Color.White) },
                    actions = {
                        Surface(shadowElevation = 10.dp, color = pinkColor, shape = RoundedCornerShape(8.dp)) {
                            IconButton(onClick = { navController.navigate("app") }) {
                                Icon(imageVector = Icons.Default.Notifications, contentDescription = "null")
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        pinkColor
                    )
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Image(
                painter = painterResource(id = R.drawable.add_note_icon),
                contentDescription = "Add Note Icon",
                modifier = Modifier.padding(16.dp) // Adjust padding as needed
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {

                Text(
                    text = "Want to Add a Note? 🗒️",
                    color = pinkColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 20.dp)
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = { navController.navigate("note") },
                        shape = RoundedCornerShape(25.dp),
                        modifier = Modifier.size(64.dp),
                        enabled = true,
                        elevation = ButtonDefaults.buttonElevation(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Icon",
                            tint = pinkColor,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }

                Text(
                    text = "Check for Saved Notes.⇓⇓",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(12.dp),
                    color = pinkColor
                )


                Button(
                    onClick = { navController.navigate("AllNotes") },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier.padding(12.dp),
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                ) {
                    Text(text = "Notes", color = pinkColor)
                }


                Button(
                    onClick = { navController.navigate("support") },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .padding(2.dp)
                        .align(Alignment.Start),
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                ) {
                    Text(text = "Support or Feedback?", color = pinkColor)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAppPreviewPreview(navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    val pinkColor = Color(0xFFFFA500)
    val veryLightPink = Color(0xFFFFDAB9)
    val text1 = "Please be informed that our application is currently undergoing processing. " +
            "We are actively working to ensure everything runs smoothly and efficiently. " +
            "We appreciate your understanding during this time as we strive to add more " +
            "features for your enjoyment. Stay tuned for exciting updates.!"

    val notifications = listOf(
        "Exciting Update: Dark Mode Coming Soon!🤩\n" +
                "\n" +
                "We are excited to announce that dark mode will be available soon. Stay tuned for this feature!📳",
        "Attention! New Update Available\n\nWe are excited to announce that you can now update your pre-existing notes with new features and improvements. 🤩 Check out the latest features and enhance your note-taking experience!🗒️🗒️",
        "Scheduled Maintenance\n\nOur application will be undergoing scheduled maintenance this weekend. We apologize for any inconvenience this may cause and appreciate your patience.",
        "Notice: Application Under Development\n" +
                "\n" +
                "We would like to inform you that our application is currently under development. If you encounter any issues or are not satisfied with any aspect, please go to the support section and provide your feedback immediately.\n" +
                "\n" +
                "Thank you for your understanding and support.",
        "Performance Improvements\n\nWe've made several performance improvements to make the app faster and more responsive. Enjoy a smoother experience!",
        "Bug Fixes\n\nWe have fixed several bugs reported by our users. Thank you for your feedback and support!"
    )

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = pinkColor),
            title = { Text(text = "Notes", color = Color.White) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                pinkColor
            )
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = "UPDATE", fontWeight = FontWeight.Bold, color = Color.Red)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "arrow",
                modifier = Modifier
                    .size(25.dp)
                    .clickable { expanded = !expanded },
                tint = Color.Red
            )
        }

        AnimatedVisibility(visible = expanded) {
            Text(
                text = text1,
                fontWeight = FontWeight.Bold,
                lineHeight = 20.sp,
                color = pinkColor,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Text(
                text = "${notifications.size} New Notifications 🔔",
                color = Color.Gray,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            items(notifications) { message ->
                Surface(
                    shadowElevation = 8.dp,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text(
                        text = message,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 16.sp,
                        color = Color.Gray, // Pink color
                        modifier = Modifier.padding(16.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp)) // Add space between items
            }
        }
    }
}