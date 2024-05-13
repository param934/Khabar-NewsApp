package com.example.newsapp.presentation.news_screen;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001e\u001a\u00020\u0006J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000eH\u0002J\u000e\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u000eH\u0002J\u001e\u0010\'\u001a\u00020 2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00178F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006-"}, d2 = {"Lcom/example/newsapp/presentation/news_screen/NewsScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "newsRepository", "Lcom/example/newsapp/domain/repository/NewsRepository;", "(Lcom/example/newsapp/domain/repository/NewsRepository;)V", "<set-?>", "Lcom/example/newsapp/presentation/news_screen/Concode;", "_countyCode", "get_countyCode", "()Lcom/example/newsapp/presentation/news_screen/Concode;", "set_countyCode", "(Lcom/example/newsapp/presentation/news_screen/Concode;)V", "_countyCode$delegate", "Landroidx/compose/runtime/MutableState;", "", "code", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "code$delegate", "searchJob", "Lkotlinx/coroutines/Job;", "Lcom/example/newsapp/presentation/news_screen/NewsScreenState;", "state", "getState", "()Lcom/example/newsapp/presentation/news_screen/NewsScreenState;", "setState", "(Lcom/example/newsapp/presentation/news_screen/NewsScreenState;)V", "state$delegate", "country", "getNewsArticles", "", "category", "onEvent", "event", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent;", "searchForNews", "query", "setCountry", "context", "Landroid/content/Context;", "lat", "", "long", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class NewsScreenViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.newsapp.domain.repository.NewsRepository newsRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState code$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState state$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState _countyCode$delegate = null;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job searchJob;
    
    @javax.inject.Inject
    public NewsScreenViewModel(@org.jetbrains.annotations.NotNull
    com.example.newsapp.domain.repository.NewsRepository newsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCode() {
        return null;
    }
    
    public final void setCode(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.newsapp.presentation.news_screen.NewsScreenState getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull
    com.example.newsapp.presentation.news_screen.NewsScreenState p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.newsapp.presentation.news_screen.Concode country() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.newsapp.presentation.news_screen.Concode get_countyCode() {
        return null;
    }
    
    public final void set_countyCode(@org.jetbrains.annotations.NotNull
    com.example.newsapp.presentation.news_screen.Concode p0) {
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    com.example.newsapp.presentation.news_screen.NewsScreenEvent event) {
    }
    
    public final void setCountry(@org.jetbrains.annotations.NotNull
    android.content.Context context, double lat, double p2_1663806) {
    }
    
    private final void getNewsArticles(java.lang.String category) {
    }
    
    private final void searchForNews(java.lang.String query) {
    }
}