package com.example.newsapp.landing;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, xi = 48, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a2\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\r"}, d2 = {"LocationPermissionPage", "", "navController", "Landroidx/navigation/NavHostController;", "context", "Landroid/content/Context;", "RequestLocationPermission", "onPermissionGranted", "Lkotlin/Function0;", "onPermissionDenied", "onPermissionsRevoked", "areLocationPermissionsGranted", "", "app_debug"})
public final class LandingPageKt {
    
    @androidx.compose.runtime.Composable
    public static final void LocationPermissionPage(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public static final boolean areLocationPermissionsGranted(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {com.google.accompanist.permissions.ExperimentalPermissionsApi.class})
    public static final void RequestLocationPermission(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPermissionGranted, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPermissionDenied, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPermissionsRevoked) {
    }
}