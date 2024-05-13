package com.example.newsapp.presentation.news_screen;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a@\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a8\u0006\u0010"}, d2 = {"NewsArticleList", "", "state", "Lcom/example/newsapp/presentation/news_screen/NewsScreenState;", "onCardClicked", "Lkotlin/Function1;", "Lcom/example/newsapp/domain/model/Article;", "onRetry", "Lkotlin/Function0;", "NewsScreen", "navController", "Landroidx/navigation/NavController;", "onEvent", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent;", "onReadFullStoryButtonClick", "", "app_release"})
public final class NewsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, androidx.compose.foundation.ExperimentalFoundationApi.class, androidx.compose.ui.ExperimentalComposeUiApi.class})
    @androidx.compose.runtime.Composable
    public static final void NewsScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull
    com.example.newsapp.presentation.news_screen.NewsScreenState state, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.newsapp.presentation.news_screen.NewsScreenEvent, kotlin.Unit> onEvent, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onReadFullStoryButtonClick) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void NewsArticleList(@org.jetbrains.annotations.NotNull
    com.example.newsapp.presentation.news_screen.NewsScreenState state, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.newsapp.domain.model.Article, kotlin.Unit> onCardClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry) {
    }
}