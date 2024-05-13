package com.example.newsapp.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class MyViewModelFactory(private val dao: StringDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(BookmarkModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BookmarkModel(dao ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
