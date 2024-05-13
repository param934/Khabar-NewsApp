package com.example.newsapp.presentation.component

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MicOff
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.isFinite
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsapp.TalkBackData.MainViewModel
import com.example.newsapp.TalkBackData.MainViewModelFactory
import com.example.newsapp.domain.model.Article

@Composable
fun BottomSheetContent(
    article: Article,
    onReadFullStoryButtonClicked: () -> Unit
) {
    var context = LocalContext.current
    val viewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context))

    // State to track mic status
    var isMicActive by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.detectTripleTapGesture {
            if (!isMicActive) {
                viewModel.readContent()
            } else {
                viewModel.stopReading()
            }
            // Toggle mic status
            isMicActive = !isMicActive
        }) {
            viewModel.readFileContent(article.content.toString())
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = article.description ?: "",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            ImageHolder(imageUrl = article.urlToImage)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = article.content ?: "",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = article.author ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = article.source.name ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
            }

            // Toggle Mic Button
            Button(
                onClick = {
                    if (!isMicActive) {
                        viewModel.readContent()
                    } else {
                        viewModel.stopReading()
                    }
                    // Toggle mic status
                    isMicActive = !isMicActive
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = if (isMicActive) Icons.Filled.VolumeUp else Icons.Filled.VolumeOff,
                    contentDescription = if (isMicActive) "Stop Mic" else "Mic"
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onReadFullStoryButtonClicked
            ) {
                Icon(imageVector = Icons.Default.MenuBook, contentDescription = "OpenBook")
            }
        }
    }
}
private const val TRIPLE_TAP_TIMEOUT_MS = 300L

@SuppressLint("ModifierFactoryUnreferencedReceiver")
@Composable
fun Modifier.detectTripleTapGesture(onTripleTap: () -> Unit): Modifier {
    return pointerInput(Unit) {
        var tapCount = 0
        var lastTapTimestamp = 0L

        detectTapGestures(
            onTap = {
                val currentTimestamp = System.currentTimeMillis()
                if (currentTimestamp - lastTapTimestamp < TRIPLE_TAP_TIMEOUT_MS) {
                    tapCount++
                } else {
                    tapCount = 1
                }
                lastTapTimestamp = currentTimestamp

                if (tapCount == 3) {
                    onTripleTap()
                    tapCount = 0
                }
            }
        )
    }
}