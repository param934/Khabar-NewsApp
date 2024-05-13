package com.example.newsapp.bookmark

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapp.domain.model.Source

@Entity(tableName = "string_table")
data class StringEntity(
    val content:String,
    val title:String,
    val url:String,
    val imageurl:String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int =0
)
