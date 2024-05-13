package com.example.newsapp.presentation.news_screen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsapp.ComponentRectangleLineLong
import com.example.newsapp.ComponentRectangleLineShort
import com.example.newsapp.ComponentSquare
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource

class Load {

    @Composable
    fun LoadinUI() {
        var isLoadingCompleted by remember { mutableStateOf(false) }
        var isLightModeActive by remember { mutableStateOf(true) }
        Column(Modifier.padding(10.dp)) {
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