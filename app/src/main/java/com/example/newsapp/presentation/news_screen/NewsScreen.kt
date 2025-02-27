package com.example.newsapp.presentation.news_screen

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.component.BottomSheetContent
import com.example.newsapp.presentation.component.CategoryTabRow
import com.example.newsapp.presentation.component.NewsArticleCard
import com.example.newsapp.presentation.component.NewsScreenTopBar
import com.example.newsapp.presentation.component.RetryContent
import com.example.newsapp.presentation.component.SearchAppBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun NewsScreen(
    navController:NavController,
    state: NewsScreenState,
    onEvent: (NewsScreenEvent) -> Unit,
    onReadFullStoryButtonClick: (String) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val coroutineScope = rememberCoroutineScope()

    val categories = listOf(
        "General", "Business", "Health", "Science", "Sports", "Technology", "Entertainment"
    )
    val pagerState = rememberPagerState(pageCount = { categories.size })
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onEvent(NewsScreenEvent.OnCategoryChanged(category = categories[page]))
        }
    }

    LaunchedEffect(key1 = Unit) {
        if (state.searchQuery.isNotEmpty()) {
            onEvent(NewsScreenEvent.OnSearchQueryChanged(searchQuery = state.searchQuery))
        }
    }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var shouldBottomSheetShow by remember { mutableStateOf(false) }

    if (shouldBottomSheetShow) {
        ModalBottomSheet(
            onDismissRequest = { shouldBottomSheetShow = false },
            sheetState = sheetState,
            content = {
                state.selectedArticle?.let {
                    BottomSheetContent(
                        article = it,
                        onReadFullStoryButtonClicked = {
                            onReadFullStoryButtonClick(it.url)
                            coroutineScope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) shouldBottomSheetShow = false
                            }
                        }
                    )
                }
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Crossfade(targetState = state.isSearchBarVisible) { isVisible ->
            if (isVisible) {
                Column {
                    SearchAppBar(
                        modifier = Modifier.focusRequester(focusRequester),
                        value = state.searchQuery,
                        onValueChange = { newValue ->
                            onEvent(NewsScreenEvent.OnSearchQueryChanged(newValue))
                        },
                        onCloseIconClicked = { onEvent(NewsScreenEvent.OnCloseIconClicked) },
                        onSearchClicked = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    )
                    NewsArticleList(
                        state = state,
                        onCardClicked = { article ->
                            shouldBottomSheetShow = true
                            onEvent(NewsScreenEvent.OnNewsCardClicked(article = article))
                        },
                        onRetry = {
                            onEvent(NewsScreenEvent.OnSearchQueryChanged(state.searchQuery))
                        }
                    )
                }
            } else {
                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        NewsScreenTopBar(
                            imageVector = Icons.Filled.Search,
                            scrollBehavior = scrollBehavior,
                            onSearchIconClicked = {
                                onEvent(NewsScreenEvent.OnSearchIconClicked)
                                coroutineScope.launch {
                                    delay(500)
                                    focusRequester.requestFocus()
                                }
                            }
                        )
                    }, bottomBar = {
                        BottomAppBar(
                            Modifier.requiredHeight(60.dp),
                            containerColor = MaterialTheme.colorScheme.primaryContainer,

                            ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(Icons.Filled.Home, "Home", modifier = Modifier.size(32.dp))
                                }
                                IconButton(onClick = {  onEvent(NewsScreenEvent.OnSearchIconClicked)
                                    coroutineScope.launch {
                                        delay(500)
                                        focusRequester.requestFocus()
                                    } }) {
                                    Icon(Icons.Filled.Search, "Search", modifier = Modifier.size(32.dp))
                                }
                                IconButton(onClick = { navController.navigate("bookmark")}) {
                                    Icon(Icons.Default.Bookmarks, "Profile", modifier = Modifier.size(32.dp))
                                }

                            }

                        }
                    }
                ) { padding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        CategoryTabRow(
                            pagerState = pagerState,
                            categories = categories,
                            onTabSelected = { index ->
                                coroutineScope.launch { pagerState.animateScrollToPage(index) }
                            }
                        )
                        HorizontalPager(
                            state = pagerState
                        ) {
                            NewsArticleList(
                                state = state,
                                onCardClicked = { article ->
                                    shouldBottomSheetShow = true
                                    onEvent(NewsScreenEvent.OnNewsCardClicked(article = article))
                                },
                                onRetry = {
                                    onEvent(NewsScreenEvent.OnCategoryChanged(state.category))
                                }
                            )
                        }
                    }
                }
            }
        }
    }


}


@Composable
fun NewsArticleList(
    state: NewsScreenState,
    onCardClicked: (Article) -> Unit,
    onRetry: () -> Unit,
) {

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(state.articles) { article ->
            NewsArticleCard(
                article = article,
                onCardClicked = onCardClicked
            )
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            Column(Modifier.offset(x=-80.dp)){ Load().LoadinUI() }
        }
        if (state.error != null) {
            RetryContent(
                error = state.error,
                onRetry = onRetry
            )
        }
    }
}