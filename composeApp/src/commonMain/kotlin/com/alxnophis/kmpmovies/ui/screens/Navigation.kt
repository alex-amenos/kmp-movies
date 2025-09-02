package com.alxnophis.kmpmovies.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alxnophis.kmpmovies.movies
import com.alxnophis.kmpmovies.ui.screens.detail.DetailScreen
import com.alxnophis.kmpmovies.ui.screens.home.HomeScreen

enum class AppScreen(
    val route: String,
) {
    HOME("home"),
    DETAIL("details/{${NavigationArguments.MOVIE_ID.value}}"),
}

enum class NavigationArguments(
    val value: String,
) {
    MOVIE_ID("movieId"),
}

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.HOME.route,
        modifier = modifier,
    ) {
        composable(AppScreen.HOME.route) {
            HomeScreen(
                onMovieClick = { movie ->
                    navController.navigate("details/${movie.id}")
                },
            )
        }
        composable(
            route = AppScreen.DETAIL.route,
            arguments = listOf(navArgument(NavigationArguments.MOVIE_ID.value) { type = NavType.IntType }),
        ) { backStackEntry: NavBackStackEntry ->
            val movieId =
                backStackEntry
                    .savedStateHandle
                    .get<Int>(NavigationArguments.MOVIE_ID.value)
            DetailScreen(
                movie = movies.first { it.id == movieId },
                onBack = { navController.popBackStack() },
            )
        }
    }
}
