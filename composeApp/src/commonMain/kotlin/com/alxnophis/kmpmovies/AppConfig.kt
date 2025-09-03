package com.alxnophis.kmpmovies

object AppConfig {
    val isDebug: Boolean get() = getPlatform().isDebug
    val platformName: String get() = getPlatform().name
}
