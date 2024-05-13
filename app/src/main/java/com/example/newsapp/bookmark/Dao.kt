package com.example.newsapp.bookmark

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StringDao {
    @Insert
    fun insert(stringEntity: StringEntity)

    @Query("SELECT * FROM string_table")
    fun getAllStrings(): LiveData<List<StringEntity>>

    @Query("SELECT * FROM string_table WHERE title = :value LIMIT 1")
    fun getStringByValue(value: String): StringEntity?

    @Query("DELETE FROM string_table WHERE title = :value")
    fun deleteByTitle(value: String)
}
