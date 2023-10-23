package com.example.noteapp.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.util.UUID
@ProvidedTypeConverter
class UUIDConvertor {
	@TypeConverter
	fun fromUUID(uuid:UUID): String {
		return uuid.toString()
	}
	@TypeConverter
	fun uuidFromString(string:String):UUID{
		return UUID.fromString(string)
	}

}