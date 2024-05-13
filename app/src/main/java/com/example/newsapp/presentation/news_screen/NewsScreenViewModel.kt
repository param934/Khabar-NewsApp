package com.example.newsapp.presentation.news_screen

import android.content.Context
import android.location.Geocoder
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

sealed interface Concode {
    data class Success(val concode: String) : Concode
    object Error : Concode
    object Loading : Concode
}

@HiltViewModel
class NewsScreenViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {


    var code by mutableStateOf("")
    var state by mutableStateOf(NewsScreenState())
    fun country(): Concode {
        return _countyCode
    }
    var _countyCode by mutableStateOf<Concode>(Concode.Loading)
    private var searchJob: Job? = null
    fun onEvent(event: NewsScreenEvent) {
        when (event) {
            is NewsScreenEvent.OnCategoryChanged -> {
                state = state.copy(category = event.category)
                getNewsArticles(category = state.category)
            }

            is NewsScreenEvent.OnNewsCardClicked -> {
                state = state.copy(selectedArticle = event.article)
            }

            NewsScreenEvent.OnSearchIconClicked -> {
                state = state.copy(
                    isSearchBarVisible = true,
                    articles = emptyList()
                )
            }

            NewsScreenEvent.OnCloseIconClicked -> {
                state = state.copy(isSearchBarVisible = false)
                getNewsArticles(category = state.category)
            }

            is NewsScreenEvent.OnSearchQueryChanged -> {
                state = state.copy(searchQuery = event.searchQuery)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(1000L)
                    searchForNews(query = state.searchQuery)
                }
            }
        }
    }


    fun setCountry(context: Context, lat: Double, long: Double) {

        try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses = geocoder.getFromLocation(lat, long, 1)
            _countyCode = if (addresses != null && addresses.isNotEmpty()) {
                code = addresses[0].countryCode ?: "NULL"
                Concode.Success(addresses[0].countryCode ?: "NULL")
            } else {
                Concode.Error
            }
        } catch (e: Exception) {
            e.printStackTrace()
            _countyCode = Concode.Error
        }

    }

    private fun getNewsArticles(category: String) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            when (_countyCode) {
                is Concode.Success -> {
                    val countryCode = (_countyCode as Concode.Success).concode // Extract the country code from Concode.Success
                    val result = newsRepository.getTopHeadlines(category = category, countryCode)
                    when (result) {
                        is Resource.Success -> {
                            state = state.copy(
                                articles = result.data ?: emptyList(),
                                isLoading = false,
                                error = null
                            )
                        }
                        is Resource.Error -> {
                            state = state.copy(
                                articles = emptyList(),
                                isLoading = false,
                                error = result.message
                            )
                        }
                    }
                }
                Concode.Loading -> println("Loading")
                Concode.Error -> println("Error")
            }
        }
    }


    private fun searchForNews(query: String) {
        if (query.isEmpty()) {
            return
        }
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = newsRepository.searchForNews(query = query)
            when (result) {
                is Resource.Success -> {
                    state = state.copy(
                        articles = result.data ?: emptyList(),
                        isLoading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    state = state.copy(
                        articles = emptyList(),
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}