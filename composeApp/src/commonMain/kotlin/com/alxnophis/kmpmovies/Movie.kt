package com.alxnophis.kmpmovies

data class Movie(
    val id: Int,
    val title: String,
    val posterUrl: String,
)

val movies: List<Movie> =
    (1..100).map {
        Movie(
            id = it,
            title = "Movie $it",
            posterUrl = "https://picsum.photos/200/300?random=$it",
        )
    }
