package com.example.newsapp.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.newsapp.bookmark.BookmarkModel
import com.example.newsapp.presentation.component.NewsScreenTopBar

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.model.Source
import com.example.newsapp.presentation.component.ImageHolder
import com.example.newsapp.presentation.component.NewsArticleCard
import com.example.newsapp.presentation.news_screen.NewsScreenEvent
import com.example.newsapp.presentation.news_screen.NewsScreenState
import com.example.newsapp.presentation.news_screen.NewsScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookmarkpageUI(
    viewModel: NewsScreenViewModel,
    navController: NavController,
    viewmodel: BookmarkModel
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val data by viewmodel.allStrings.observeAsState(emptyList())


    Scaffold(
        topBar = {
            NewsScreenTopBar(
                imageVector = Icons.Default.ArrowBack,
                scrollBehavior = scrollBehavior,
                onSearchIconClicked = {
                    navController.popBackStack()
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn {

                println(data)
                data.let { items ->
                    println(it)
                    items(items) { it ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 16.dp)
                                .clickable {
                                    navController.navigate(
                                        "article_screen?web_url=${it.url}"
                                    )
                                    it.imageurl?.let { it1 -> Article(title = it.title, url = it.url, urlToImage = it1, content = it.content, author = "", publishedAt = "", description = "", source = Source(id = it.id.toString(),name = "")) }
                                        ?.let { it2 ->
                                            NewsScreenEvent.OnNewsCardClicked(
                                                it2
                                            )
                                        }?.let { it3 -> viewModel.onEvent(event = it3) }

                                }
                        ) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                ImageHolder(
                                    imageUrl = it.imageurl,
                                    modifier = Modifier.height(100.dp)
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = it.title,
                                        style = MaterialTheme.typography.titleMedium,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = truncateContent(it.content ?: ""),
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Color.Gray,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun truncateContent(content: String): String {
    val words = content.split(" ")
    return if (words.size > 30) {
        words.take(30).joinToString(" ") + "..."
    } else {
        content
    }
}
