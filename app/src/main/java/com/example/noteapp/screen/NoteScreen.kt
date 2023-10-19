package com.example.noteapp.screen
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.components.NoteButton
import com.example.noteapp.components.NoteInputText
import com.example.noteapp.data.NoteDataSource
import com.example.noteapp.model.Note
import java.time.format.DateTimeFormatter
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes : List<Note>, onAddNote : (Note) -> Unit, onRemoveNote : (Note) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(Color.Gray), title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(imageVector = Icons.Rounded.Notifications, contentDescription = null)
        })
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                text = title, label = "title", onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                }, modifier = Modifier
            )
            NoteInputText(
                text = description, label = "Add a note", onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it
                }, modifier = Modifier
            )
            NoteButton(text = "Save", onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    onAddNote(Note(title=title, description = description))
                    title = ""
                    description = ""
                }
            })
        }
        Divider(Modifier.padding(8.dp))
        LazyColumn {
            items(notes) { note ->
                NoteRow(note = note, onNoteClicked = {onRemoveNote(
                    note

                )})
            }
        }
    }
}
@Composable
fun NoteRow(
    modifier : Modifier = Modifier, note : Note, onNoteClicked : (Note) -> Unit
) {
    Surface(
        shadowElevation = 6.dp, color = Color(0xFFDFE6EB), modifier = Modifier
            .padding(4.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = 33.dp, bottomStart = 33.dp
                )
            )
    ) {
        Column(modifier = Modifier
            .clickable { onNoteClicked(note)
            println("note is $note")
            }
            .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = note.title)
            Text(text = note.description)
//            Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")))
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun NoteScreenPreview() {
    NoteScreen(notes = NoteDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}