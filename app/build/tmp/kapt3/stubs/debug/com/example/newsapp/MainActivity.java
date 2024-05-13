package com.example.newsapp;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JR\u0010\u0010\u001a\u00020\u00112\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00110\u00132\u0016\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012\u0004\u0012\u00020\u00110\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0012\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J-\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00042\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\'H\u0016\u00a2\u0006\u0002\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e\u00a8\u0006)"}, d2 = {"Lcom/example/newsapp/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "LOCATION_PERMISSION_REQUEST_CODE", "", "bookmarkmodel", "Lcom/example/newsapp/bookmark/BookmarkModel;", "getBookmarkmodel", "()Lcom/example/newsapp/bookmark/BookmarkModel;", "bookmarkmodel$delegate", "Lkotlin/Lazy;", "db", "Lcom/example/newsapp/bookmark/Bookmarkdb;", "getDb", "()Lcom/example/newsapp/bookmark/Bookmarkdb;", "db$delegate", "getCurrentLocation", "", "onGetCurrentLocationSuccess", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "onGetCurrentLocationFailed", "Ljava/lang/Exception;", "Lkotlin/Exception;", "priority", "", "context", "Landroid/content/Context;", "isLocationPermissionGranted", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    private final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy db$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy bookmarkmodel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.newsapp.bookmark.Bookmarkdb getDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.newsapp.bookmark.BookmarkModel getBookmarkmodel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void getCurrentLocation(kotlin.jvm.functions.Function1<? super kotlin.Pair<java.lang.Double, java.lang.Double>, kotlin.Unit> onGetCurrentLocationSuccess, kotlin.jvm.functions.Function1<? super java.lang.Exception, kotlin.Unit> onGetCurrentLocationFailed, boolean priority, android.content.Context context) {
    }
    
    private final boolean isLocationPermissionGranted() {
        return false;
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
}