package com.example.anoteapp.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatdate(time:Long):String{
    val date = Date(time)
    val dateFormat = SimpleDateFormat("EEE, dd MMM hh:mm aaa", Locale.getDefault())
    return dateFormat.format(date)

}