package com.fghilmany.baseproject.feature.movielist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fghilmany.baseproject.factories.MainComponent
import com.fghilmany.baseproject.feature.movielist.domain.Movie
import com.fghilmany.baseproject.feature.movielist.presentation.MoviesViewModel
import com.fghilmany.baseproject.feature.movielist.ui.MoviesRoute

const val moviesGraphRoute = "movies_graph_route"
const val moviesRoute = "movies_feed_route"

fun NavGraphBuilder.moviesGraph(
    mainComponent: MainComponent,
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
            val viewModel: MoviesViewModel = viewModel {
                mainComponent.listMovieViewModel()
            }
            MoviesRoute(
                viewModel = viewModel,
                onNavigateToMovieDetail = onMovieClick
            )
        }
        nestedGraphs()
    }
}