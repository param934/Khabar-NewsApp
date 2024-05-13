package com.example.newsapp.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreenTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onSearchIconClicked: () -> Unit,
    imageVector: ImageVector
) {
    val titleImage: Painter = painterResource(id = R.drawable.kabarlogo)

    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Box(Modifier.size(136.dp)) {
                Icon(
                    painter = titleImage,
                    contentDescription = null,
                    modifier = Modifier.matchParentSize()
                )
            }
        },
        actions = {
            IconButton(onClick = onSearchIconClicked) {
                Icon(imageVector = imageVector, contentDescription = "Search")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}