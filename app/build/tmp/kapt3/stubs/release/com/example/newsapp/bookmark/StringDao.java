package com.example.newsapp.bookmark;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\'J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\'\u00a8\u0006\r"}, d2 = {"Lcom/example/newsapp/bookmark/StringDao;", "", "deleteByTitle", "", "value", "", "getAllStrings", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/newsapp/bookmark/StringEntity;", "getStringByValue", "insert", "stringEntity", "app_release"})
@androidx.room.Dao
public abstract interface StringDao {
    
    @androidx.room.Insert
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.newsapp.bookmark.StringEntity stringEntity);
    
    @androidx.room.Query(value = "SELECT * FROM string_table")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.newsapp.bookmark.StringEntity>> getAllStrings();
    
    @androidx.room.Query(value = "SELECT * FROM string_table WHERE title = :value LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract com.example.newsapp.bookmark.StringEntity getStringByValue(@org.jetbrains.annotations.NotNull
    java.lang.String value);
    
    @androidx.room.Query(value = "DELETE FROM string_table WHERE title = :value")
    public abstract void deleteByTitle(@org.jetbrains.annotations.NotNull
    java.lang.String value);
}