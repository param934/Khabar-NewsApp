package com.example.newsapp.presentation.news_screen;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent;", "", "()V", "OnCategoryChanged", "OnCloseIconClicked", "OnNewsCardClicked", "OnSearchIconClicked", "OnSearchQueryChanged", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent$OnCategoryChanged;", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent$OnCloseIconClicked;", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent$OnNewsCardClicked;", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent$OnSearchIconClicked;", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent$OnSearchQueryChanged;", "app_release"})
public abstract class NewsScreenEvent {
    
    private NewsScreenEvent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent$OnCategoryChanged;", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent;", "category", "", "(Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"})
    public static final class OnCategoryChanged extends com.example.newsapp.presentation.news_screen.NewsScreenEvent {
        @org.jetbrains.annotations.NotNull
        private java.lang.String category;
        
        public OnCategoryChanged(@org.jetbrains.annotations.NotNull
        java.lang.String category) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCategory() {
            return null;
        }
        
        public final void setCategory(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.newsapp.presentation.news_screen.NewsScreenEvent.OnCategoryChanged copy(@org.jetbrains.annotations.NotNull
        java.lang.String category) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent$OnCloseIconClicked;", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent;", "()V", "app_release"})
    public static final class OnCloseIconClicked extends com.example.newsapp.presentation.news_screen.NewsScreenEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.example.newsapp.presentation.news_screen.NewsScreenEvent.OnCloseIconClicked INSTANCE = null;
        
        private OnCloseIconClicked() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent$OnNewsCardClicked;", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent;", "article", "Lcom/example/newsapp/domain/model/Article;", "(Lcom/example/newsapp/domain/model/Article;)V", "getArticle", "()Lcom/example/newsapp/domain/model/Article;", "setArticle", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"})
    public static final class OnNewsCardClicked extends com.example.newsapp.presentation.news_screen.NewsScreenEvent {
        @org.jetbrains.annotations.NotNull
        private com.example.newsapp.domain.model.Article article;
        
        public OnNewsCardClicked(@org.jetbrains.annotations.NotNull
        com.example.newsapp.domain.model.Article article) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.newsapp.domain.model.Article getArticle() {
            return null;
        }
        
        public final void setArticle(@org.jetbrains.annotations.NotNull
        com.example.newsapp.domain.model.Article p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.newsapp.domain.model.Article component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.newsapp.presentation.news_screen.NewsScreenEvent.OnNewsCardClicked copy(@org.jetbrains.annotations.NotNull
        com.example.newsapp.domain.model.Article article) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent$OnSearchIconClicked;", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent;", "()V", "app_release"})
    public static final class OnSearchIconClicked extends com.example.newsapp.presentation.news_screen.NewsScreenEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.example.newsapp.presentation.news_screen.NewsScreenEvent.OnSearchIconClicked INSTANCE = null;
        
        private OnSearchIconClicked() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent$OnSearchQueryChanged;", "Lcom/example/newsapp/presentation/news_screen/NewsScreenEvent;", "searchQuery", "", "(Ljava/lang/String;)V", "getSearchQuery", "()Ljava/lang/String;", "setSearchQuery", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"})
    public static final class OnSearchQueryChanged extends com.example.newsapp.presentation.news_screen.NewsScreenEvent {
        @org.jetbrains.annotations.NotNull
        private java.lang.String searchQuery;
        
        public OnSearchQueryChanged(@org.jetbrains.annotations.NotNull
        java.lang.String searchQuery) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSearchQuery() {
            return null;
        }
        
        public final void setSearchQuery(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.newsapp.presentation.news_screen.NewsScreenEvent.OnSearchQueryChanged copy(@org.jetbrains.annotations.NotNull
        java.lang.String searchQuery) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}