package com.example.aNoteApp.data




import com.example.anoteapp.data.Note

class Data {
    fun loadNotes():List<Note>{
        return listOf(
            Note(
                title = "Note 1 Title",
                description = "Note 1 Description"
            ),
            Note(
                title = "Note 2 Title",
                description = "Note 2 Description"
            ),
            Note(
                title = "Note 3 Title",
                description = "Note 3 Description"
            ),
            Note(
                title = "Note 4 Title",
                description = "Note 4 Description"
            ),
            Note(
                title = "Note 5 Title",
                description = "Note 5 Description"
            )

        )
    }
}