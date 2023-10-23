package com.example.noteapp.components
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(
    modifier : Modifier = Modifier,
    text : String,
    label : String,
    maxLine : Int = 1,
    onTextChange : (String) -> Unit,
    onImeAction : () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
   TextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,

        maxLines = maxLine,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        })
    )
}
@Composable
fun NoteButton(
    modifier : Modifier = Modifier, text : String, onClick : () -> Unit, enabled : Boolean = true
) {
    Button(onClick = onClick, enabled = enabled, shape = CircleShape, modifier = Modifier) {
        Text(text = text)
    }
}