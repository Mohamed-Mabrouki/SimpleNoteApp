package com.example.noteapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID


data class Note (
    val id:UUID= UUID.randomUUID(),
    val title:String,
    val description:String,
    val entryDate: LocalDateTime= LocalDateTime.now()
)