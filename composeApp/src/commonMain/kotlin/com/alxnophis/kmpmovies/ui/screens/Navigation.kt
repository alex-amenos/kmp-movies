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

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier,
    ) {
        composable("home") {
            HomeScreen(
                onMovieClick = { movie ->
                    navController.navigate("details/${movie.id}")
                },
            )
        }
        composable(
            route = "details/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType }),
        ) { backStackEntry: NavBackStackEntry ->
            val movieId =
                backStackEntry
                    .savedStateHandle
                    .get<Int>("movieId")
            DetailScreen(
                movie = movies.first { it.id == movieId },
                onBack = { navController.popBackStack() },
            )
        }
    }
}
