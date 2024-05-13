package com.example.newsapp.bookmark;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/newsapp/bookmark/StringDao;", "", "getAllStrings", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/newsapp/bookmark/StringEntity;", "getStringByValue", "value", "", "insert", "", "stringEntity", "app_debug"})
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
}