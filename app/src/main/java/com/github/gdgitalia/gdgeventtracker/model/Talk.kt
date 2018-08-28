package com.github.gdgitalia.gdgeventtracker.model

import java.util.*

data class Talk(val title: String, val abstract: String, val technology: String, val type: String,
                val date: Date, val hashtag: String, val language: String, val level: String,
                val speaker: String) {

}