package com.fghilmany.baseproject.feature.movielist.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fghilmany.baseproject.feature.movielist.presentation.MoviesViewModel
import com.fghilmany.baseproject.feature.movielist.ui.MoviesRoute
import androidx.hilt.navigation.compose.hiltViewModel

const val moviesGraphRoute = "movies_graph_route"
const val moviesRoute = "movies_feed_route"

fun NavGraphBuilder.moviesGraph(
    onMovieClick: (Int) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = moviesGraphRoute,
        startDestination = moviesRoute
    ) {
        composable(
            route = moviesRoute
        ) {
            val viewModel: MoviesViewModel = hiltViewModel()
            MoviesRoute(
                viewModel = viewModel,
                onNavigateToMovieDetail = onMovieClick
            )
        }
        nestedGraphs()
    }
}