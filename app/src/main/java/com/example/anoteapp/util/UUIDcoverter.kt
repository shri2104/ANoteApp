package com.example.anoteapp.util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDcoverter  {
    @TypeConverter
    fun fromUUID(uuid: UUID):String?{
         return uuid.toString()
    }
    fun toUUID(string:String?):UUID{
        return UUID.fromString(string)
    }
}