package com.example.anoteapp.Screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.anoteapp.R
import com.example.anoteapp.data.Note



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun allNotes(navController: NavController, notes: List<Note>, onRemovenote: (Note) -> Unit) {
    val pinkColor = Color(0xFFFFA500)

    Surface(modifier = Modifier.fillMaxSize(), shadowElevation = 8.dp) {
        Column() {
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

            if (notes.isEmpty()) {
                // Display a message or perform any other action if the list is empty
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text(text = "No notes available, Want to add some ? 🗒️" ,color = Color.Gray, style = MaterialTheme.typography.bodyLarge)

                        Button(onClick = { navController.navigate("note") },colors = ButtonDefaults.buttonColors(pinkColor),
                            elevation = ButtonDefaults.buttonElevation(5.dp),) {
                            Text(text = "Add Notes", )
                        }
                    }
                }
            }
            else{
                Surface(shadowElevation = 12.dp){
                    LazyColumn(modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp)) {
                        items(notes) {
                            Surface(shadowElevation = 8.dp,
                                modifier = Modifier.padding(vertical = 4.dp)) {
                                Noterow(navController,note = it, onClicked = {
                                    onRemovenote(it)
                                })
                            }

                        }
                    }

                }

            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Feedback(navController: NavController) {
    val pinkColor = Color(0xFFFFA500)
    val main="""Welcome to our support page! We value your experience and are here to help with any questions, concerns, or feedback you may have. Please feel free to reach out to us using the following contact information: """
    val supportContentTop = """
        📞 Phone Support:
        We are available to assist you with any issues or inquiries. You can reach us by phone during our business hours.
        
        Phone Number: +09644682144
        Business Hours: Monday to Friday, 9 AM - 6 PM (Your Local Time)
    """.trimIndent()

    val supportContentMiddle = """
        📧 Email Support:
        Prefer to write to us? Send us an email, and we will get back to you as soon as possible.
        
        Email Address: sharmashri2004@gmail.com
        Response Time: We aim to respond within 24-48 hours.
    """.trimIndent()

    val supportContentBottom = """
        📬 Feedback:
        Your feedback is important to us! If you have any suggestions or comments about how we can improve our service or your experience, please let us know.
        
        Feedback Email: feedback@example.com
        
        Thank you for choosing our app. We're committed to providing you with the best possible support.
    """.trimIndent()

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
       Text(text = "Support", color = Color.Gray, fontWeight = FontWeight.Bold)
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = main,
            color = Color.Gray,
            style = MaterialTheme.typography.bodyLarge,
            modifier=Modifier.padding(8.dp)
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = supportContentTop,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

            item {
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            item {
                Text(
                    text = supportContentMiddle,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

            item {
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            item {
                Text(
                    text = supportContentBottom,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

            item {
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}
