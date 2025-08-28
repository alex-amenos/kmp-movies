package com.alxnophis.kmpmovies

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.alxnophis.kmpmovies.ui.screens.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader
            .Builder(context)
            .crossfade(true)
            .logger(if (AppConfig.isDebug) DebugLogger() else null)
            .build()
    }
    HomeScreen()
}
