package com.example.newsapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.example.newsapp.TalkBackData.MainViewModel
import com.example.newsapp.TalkBackData.MainViewModelFactory
import com.example.newsapp.bookmark.BookmarkModel
import com.example.newsapp.bookmark.BookmarkRepo
import com.example.newsapp.bookmark.Bookmarkdb
import com.example.newsapp.landing.LocationPermissionPage
import com.example.newsapp.presentation.BookmarkpageUI
import com.example.newsapp.presentation.article_screen.ArticleScreen
import com.example.newsapp.presentation.news_screen.Concode
import com.example.newsapp.presentation.news_screen.Load
import com.example.newsapp.presentation.news_screen.NewsScreen
import com.example.newsapp.presentation.news_screen.NewsScreenViewModel
import com.example.newsapp.presentation.theme.NewsAppTheme
import com.example.newsapp.presentation.theme.shimmerLoadingAnimation
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val LOCATION_PERMISSION_REQUEST_CODE = 1001
    private val db by lazy{
        Room.databaseBuilder(
            applicationContext,
            Bookmarkdb::class.java,
            "Bookmark.db"
        ).build()
    }
    val bookmarkmodel by viewModels<BookmarkModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T{
                    return BookmarkModel(db.stringDao()) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val bookmarkdao = DatabaseProvider.getDatabase(applicationContext)
//
//        val bookmarkrepo = BookmarkRepo(bookmarkdao.stringDao())



        setContent {
            NewsAppTheme {
                val navController = rememberNavController()
                val argKey = "web_url"
                val viewModel: NewsScreenViewModel = hiltViewModel()
                NavHost(
                    navController = navController,
                    startDestination = if (isLocationPermissionGranted()) {
                        "news_screen"
                    } else {
                        "Loc"
                    }
                ) {
                    composable(route="bookmark"){
                        BookmarkpageUI(navController = navController, viewmodel =bookmarkmodel, viewModel = viewModel )
                    }
                    composable(route = "news_screen") {

                        LaunchedEffect(Unit) {

                            getCurrentLocation(
                                onGetCurrentLocationSuccess = {
                                    viewModel.setCountry(applicationContext, it.first, it.second)
                                },
                                onGetCurrentLocationFailed = {}, context = applicationContext
                            )


                        }
                        when (viewModel.country()) {
                            Concode.Error -> {

                            }

                            Concode.Loading -> {
                                Load().LoadinUI()
                            }

                            is Concode.Success -> {
                                NewsScreen(
                                    navController,
                                    state = viewModel.state,
                                    onEvent = viewModel::onEvent,
                                    onReadFullStoryButtonClick = { url ->
                                        navController.navigate("article_screen?$argKey=$url")
                                    }
                                )
                            }
                        }

                    }
                    composable(
                        route = "article_screen?$argKey={$argKey}",
                        arguments = listOf(navArgument(name = argKey) {
                            type = NavType.StringType
                        })
                    ) { backStackEntry ->
                        ArticleScreen(
                            state = viewModel.state,
                            bookmarkmodel,
                            url = backStackEntry.arguments?.getString(argKey),
                            onBackPressed = { navController.navigateUp() }
                        )
                    }
                    composable(route = "Loc") {
                        LocationPermissionPage(navController, this@MainActivity)
                    }
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun getCurrentLocation(
        onGetCurrentLocationSuccess: (Pair<Double, Double>) -> Unit,
        onGetCurrentLocationFailed: (Exception) -> Unit,
        priority: Boolean = true,
        context: Context
    ) {
        // Determine the accuracy priority based on the 'priority' parameter
        val accuracy = if (priority) LocationRequest.PRIORITY_HIGH_ACCURACY
        else LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY

        // Check if location permissions are granted

        // Retrieve the current location asynchronously
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationProviderClient.getCurrentLocation(
            accuracy, CancellationTokenSource().token
        ).addOnSuccessListener { location ->
            location?.let {
                // If location is not null, invoke the success callback with latitude and longitude
                onGetCurrentLocationSuccess(Pair(it.latitude, it.longitude))
            }
        }.addOnFailureListener { exception ->
            // If an error occurs, invoke the failure callback with the exception
            onGetCurrentLocationFailed(exception)
        }

    }

    private fun isLocationPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {

            }
        }
    }
}

@Composable
fun LoadingScreen() {

    var isLoadingCompleted by remember { mutableStateOf(false) }
    var isLightModeActive by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (isLightModeActive) Color.White else Color.Black)
            .border(border = BorderStroke(width = 9.dp, color = Color.Black))
            .padding(48.dp)
    ) {
        Column(
            modifier = Modifier.align(alignment = Alignment.TopCenter)
        ) {

            Column {
                ComponentRectangle(isLoadingCompleted, isLightModeActive)
                Spacer(modifier = Modifier.padding(8.dp))
                ComponentRectangleLineLong(isLoadingCompleted, isLightModeActive)
                Spacer(modifier = Modifier.padding(4.dp))
                ComponentRectangleLineShort(isLoadingCompleted, isLightModeActive)
            }

            Spacer(modifier = Modifier.padding(24.dp))

            Row {
                ComponentCircle(isLoadingCompleted, isLightModeActive)
                Spacer(modifier = Modifier.padding(4.dp))
                Column {
                    Spacer(modifier = Modifier.padding(8.dp))
                    ComponentRectangleLineLong(isLoadingCompleted, isLightModeActive)
                    Spacer(modifier = Modifier.padding(4.dp))
                    ComponentRectangleLineShort(isLoadingCompleted, isLightModeActive)
                }
            }
            Spacer(modifier = Modifier.padding(24.dp))

            Row {
                ComponentSquare(isLoadingCompleted, isLightModeActive)
                Spacer(modifier = Modifier.padding(4.dp))
                Column {
                    Spacer(modifier = Modifier.padding(8.dp))
                    ComponentRectangleLineLong(isLoadingCompleted, isLightModeActive)
                    Spacer(modifier = Modifier.padding(4.dp))
                    ComponentRectangleLineShort(isLoadingCompleted, isLightModeActive)
                }
            }
        }
    }
}

@Composable
fun ComponentCircle(
    isLoadingCompleted: Boolean,
    isLightModeActive: Boolean,
) {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray, shape = CircleShape)
            .size(100.dp)
            .shimmerLoadingAnimation(isLoadingCompleted, isLightModeActive)
    )
}

@Composable
fun ComponentSquare(
    isLoadingCompleted: Boolean,
    isLightModeActive: Boolean,
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(24.dp))
            .background(color = Color.LightGray)
            .size(100.dp)
            .shimmerLoadingAnimation(isLoadingCompleted, isLightModeActive)
    )
}

@Composable
fun ComponentRectangle(
    isLoadingCompleted: Boolean,
    isLightModeActive: Boolean,
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(24.dp))
            .background(color = Color.LightGray)
            .height(200.dp)
            .fillMaxWidth()
            .shimmerLoadingAnimation(isLoadingCompleted, isLightModeActive)
    )
}

@Composable
fun ComponentRectangleLineLong(
    isLoadingCompleted: Boolean,
    isLightModeActive: Boolean,
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.LightGray)
            .size(height = 30.dp, width = 200.dp)
            .shimmerLoadingAnimation(isLoadingCompleted, isLightModeActive)
    )
}

@Composable
fun ComponentRectangleLineShort(
    isLoadingCompleted: Boolean,
    isLightModeActive: Boolean,
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.LightGray)
            .size(height = 30.dp, width = 100.dp)
            .shimmerLoadingAnimation(isLoadingCompleted, isLightModeActive)
    )
}