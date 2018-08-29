package com.github.gdgitalia.gdgeventtracker.model

import java.util.*

data class Talk(
        val title: String = "",
        val abstract: String = "",
        val technology: String = "",
        val type: String = "",
        val date: Date = Date(),
        val hashtag: String = "",
        val language: String = "",
        val country: String = "",
        val level: Long = 0,
        val speaker: String = ""
)