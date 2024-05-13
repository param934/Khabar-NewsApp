package com.example.newsapp.bookmark

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StringEntity::class], version = 1, exportSchema = false)
abstract class Bookmarkdb : RoomDatabase() {
    abstract fun stringDao(): StringDao
}
