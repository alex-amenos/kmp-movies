package com.alxnophis.kmpmovies

interface Platform {
    val name: String
    val isDebug: Boolean
}

expect fun getPlatform(): Platform
