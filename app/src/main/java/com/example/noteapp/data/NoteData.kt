package com.example.noteapp.data


import com.example.noteapp.model.Note

class NoteDataSource {
    fun loadNotes() : List<Note> {
        return listOf(
            Note(title = "A good day", description = "we went on a vacation"),
            Note(title = "A bd day", description = "we didn't go anywhere"),
            Note(title = "A good day", description = "we went on a vacation"),
            Note(title = "A good day", description = "we went on a vacation"),
            Note(title = "A good day", description = "we went on a vacation"),
            Note(title = "A good day", description = "we went on a vacation"),
            Note(title = "A good day", description = "we went on a vacation")
            )
    }

}