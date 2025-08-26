package com.alxnophis.kmpmovies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform