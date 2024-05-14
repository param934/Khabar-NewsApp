package com.example.newsapp.data.remote;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/newsapp/data/remote/NewsApi;", "", "getBreakingNews", "Lcom/example/newsapp/domain/model/NewsResponse;", "category", "", "country", "apiKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchForNews", "query", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface NewsApi {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String API_KEY = "70b2ab56f1394dbca5773ad5525ace7f";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL = "https://newsapi.org/v2/";
    @org.jetbrains.annotations.NotNull
    public static final com.example.newsapp.data.remote.NewsApi.Companion Companion = null;
    
    @retrofit2.http.GET(value = "top-headlines")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getBreakingNews(@retrofit2.http.Query(value = "category")
    @org.jetbrains.annotations.NotNull
    java.lang.String category, @retrofit2.http.Query(value = "country")
    @org.jetbrains.annotations.NotNull
    java.lang.String country, @retrofit2.http.Query(value = "apiKey")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.newsapp.domain.model.NewsResponse> $completion);
    
    @retrofit2.http.GET(value = "everything")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object searchForNews(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull
    java.lang.String query, @retrofit2.http.Query(value = "apiKey")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.newsapp.domain.model.NewsResponse> $completion);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/newsapp/data/remote/NewsApi$Companion;", "", "()V", "API_KEY", "", "BASE_URL", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String API_KEY = "70b2ab56f1394dbca5773ad5525ace7f";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String BASE_URL = "https://newsapi.org/v2/";
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}