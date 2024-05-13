package com.example.newsapp.bookmark

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.presentation.news_screen.NewsScreenState
import kotlinx.coroutines.launch

class BookmarkModel(private val dao: StringDao) : ViewModel() {
    val isExist = mutableStateOf(false)
    val repository = BookmarkRepo(dao)

    val allStrings: LiveData<List<StringEntity>> = repository.getAllStrings()
    fun insertString(content: String , title : String,url:String,imageurl:String?) {
        viewModelScope.launch {
            repository.insertString(content,title,url,imageurl)
        }
    }

//    fun getAllStrings(): LiveData<List<StringEntity>> {
//        return repository.getAllStrings()
//    }

    fun isStringEntityExists(value: String) {
       viewModelScope.launch {
            repository.isStringEntityExists(value,isExist)
        }
    }
//    fun setbookmarks(){
//        state=state.copy(isLoading = true)
//        val
//    }
}
