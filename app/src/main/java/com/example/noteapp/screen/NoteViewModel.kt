package com.example.noteapp.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.model.Note
import com.example.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(private val repository : NoteRepository) : ViewModel() {
	private val _noteList = MutableStateFlow<List<Note>>(emptyList())
	val noteList=_noteList.asStateFlow()

	init {
		viewModelScope.launch(Dispatchers.IO) {
			repository.getAllNotes().distinctUntilChanged().collect{listofNotes->//.distinctUntilChanged() no usage in
				// this case
				if(listofNotes.isEmpty()){
					Log.d("empty","empty list")
				}else{
					_noteList.value= listofNotes
					Log.d("empty", listofNotes.toString())
				}

			}
		}
	}

	 fun addNote(note : Note) =viewModelScope.launch { repository.addNote(note) }
	 fun updateNote(note : Note) =viewModelScope.launch { repository.updateNote(note) }
	 fun removeNote(note : Note) =viewModelScope.launch { repository.deleteNote(note) }



}