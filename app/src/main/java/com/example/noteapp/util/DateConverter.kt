package com.example.noteapp.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.util.Date


class Converter {
	@TypeConverter
	fun timetoString(value: LocalDateTime): String {
		return value.toString()
	}
	@TypeConverter
	fun stringToTime(string:String): LocalDateTime {
		return LocalDateTime.parse(string)
	}




}