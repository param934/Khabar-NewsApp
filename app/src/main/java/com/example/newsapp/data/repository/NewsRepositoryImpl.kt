package com.example.newsapp.data.repository

import com.example.newsapp.data.remote.NewsApi
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.util.Resource

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {

    override suspend fun getTopHeadlines(
        category: String,
        countrycode: String
    ): Resource<List<Article>> {
        return try {
            val response = newsApi.getBreakingNews(category = category, country = countrycode)
            Resource.Success(data = response.articles)
        } catch (e: Exception) {
            Resource.Error(message = "Failed to fetch news ${e.message}")
        }
    }


    override suspend fun searchForNews(query: String): Resource<List<Article>> {
        return try {
            val response = newsApi.searchForNews(query = query)
            Resource.Success(data = response.articles)
        } catch (e: Exception) {
            Resource.Error(message = "Failed to fetch news ${e.message}")
        }
    }
}