package com.example.newsapp.bookmark;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J(\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/example/newsapp/bookmark/BookmarkModel;", "Landroidx/lifecycle/ViewModel;", "dao", "Lcom/example/newsapp/bookmark/StringDao;", "(Lcom/example/newsapp/bookmark/StringDao;)V", "allStrings", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/newsapp/bookmark/StringEntity;", "getAllStrings", "()Landroidx/lifecycle/LiveData;", "isExist", "Landroidx/compose/runtime/MutableState;", "", "()Landroidx/compose/runtime/MutableState;", "repository", "Lcom/example/newsapp/bookmark/BookmarkRepo;", "getRepository", "()Lcom/example/newsapp/bookmark/BookmarkRepo;", "delete", "", "title", "", "insertString", "content", "url", "imageurl", "isStringEntityExists", "value", "app_debug"})
public final class BookmarkModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.newsapp.bookmark.StringDao dao = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> isExist = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.newsapp.bookmark.BookmarkRepo repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.newsapp.bookmark.StringEntity>> allStrings = null;
    
    public BookmarkModel(@org.jetbrains.annotations.NotNull
    com.example.newsapp.bookmark.StringDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isExist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.newsapp.bookmark.BookmarkRepo getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.newsapp.bookmark.StringEntity>> getAllStrings() {
        return null;
    }
    
    public final void insertString(@org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.Nullable
    java.lang.String imageurl) {
    }
    
    public final void isStringEntityExists(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
}