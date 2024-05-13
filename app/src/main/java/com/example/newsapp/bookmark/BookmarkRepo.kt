package com.example.newsapp.bookmark

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class BookmarkRepo(private val stringDao: StringDao) {
    suspend fun insertString(content: String, title: String, url: String, imageurl: String?) {
        withContext(Dispatchers.IO) {
            val stringEntity = imageurl?.let { StringEntity(content = content, title, url, it) }
            if (stringEntity != null) {
                stringDao.insert(stringEntity)
            }
        }
    }

    fun getAllStrings(): LiveData<List<StringEntity>> {

        val stringEntities = stringDao.getAllStrings()
        println("--->" + stringEntities.value)
        return stringEntities

    }

    suspend fun isStringEntityExists(value: String, isExist: MutableState<Boolean>) {
        withContext(Dispatchers.IO) {
            val stringEntity = stringDao.getStringByValue(value)
            isExist.value = stringEntity != null
        }
    }

    suspend fun delete(title: String) {
        withContext(Dispatchers.IO) {
            stringDao.deleteByTitle(title)
        }
        }
    }