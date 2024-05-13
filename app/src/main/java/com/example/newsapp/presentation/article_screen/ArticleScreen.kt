package com.example.newsapp.presentation.article_screen

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkAdded
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.viewinterop.AndroidView
import com.example.newsapp.bookmark.BookmarkModel
import com.example.newsapp.LoadingScreen
import com.example.newsapp.presentation.news_screen.NewsScreenState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(
    state:NewsScreenState,
    datamodel:BookmarkModel,
    url: String?,
    onBackPressed: () -> Unit
) {
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(true) }
    var added by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(Unit) {
        state.selectedArticle?.let { datamodel.isStringEntityExists(it.title) }
    }
    if(datamodel.isExist.value){
        added=true
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if(!added){
                    if (url != null) {
                        state.selectedArticle?.content?.let {
                            datamodel.insertString(
                                it,
                                state.selectedArticle.title,
                                state.selectedArticle.url,
                                state.selectedArticle.urlToImage
                            )
                        }
                        added = true
                    }
                }else{
                    state.selectedArticle?.let { datamodel.delete(it.title)
                    added=false}
                }
            }) {
                if (!added) {
                    Icon(Icons.Filled.Bookmark, contentDescription = "Bookmarks")
                } else {
                    Icon(Icons.Filled.BookmarkAdded, contentDescription = "Bookmarks")

                }

            }
        },
        modifier = Modifier.fillMaxSize(),
        topBar = {

            TopAppBar(
                title = { Text(text = "Article", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            AndroidView(factory = {
                WebView(context).apply {
                    webViewClient = object : WebViewClient() {
                        override fun onPageFinished(view: WebView?, url: String?) {
                            isLoading = false
                        }
                    }
                    loadUrl(url ?: "")
                }
            })
            if (isLoading && url != null) {
                LoadingScreen()
            }
        }
    }
}