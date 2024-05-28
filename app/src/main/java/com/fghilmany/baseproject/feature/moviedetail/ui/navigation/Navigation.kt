package com.fghilmany.baseproject.feature.moviedetail.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fghilmany.baseproject.factories.di.ViewModelFactory
import com.fghilmany.baseproject.feature.moviedetail.presentation.DetailMovieViewModel
import com.fghilmany.baseproject.feature.moviedetail.ui.DetailMovieRoute

const val detailMovieRoute = "movie_detail_route"
const val MOVIE_ID = "movie_id"

fun NavController.navigateToMovieDetail(movieId: Int, navOptions: NavOptions? = null) {
    this.currentBackStackEntry?.savedStateHandle?.set(key = MOVIE_ID, value = movieId)
    this.navigate(detailMovieRoute, navOptions)
}

fun NavGraphBuilder.detailMovieScreen(
    popBackStack: () -> Unit,
    navHostController: NavHostController
) {
    composable(
        route = detailMovieRoute,
    ) {
        val movieId = navHostController.previousBackStackEntry?.savedStateHandle?.get<Int>(MOVIE_ID)
        val viewModel = hiltViewModel<DetailMovieViewModel, ViewModelFactory>(
            creationCallback = {
                it.createDetailMovieViewModel(movieId ?: 0)
            }
        )

        DetailMovieRoute(
            viewModel = viewModel,
            popBackStack = popBackStack
        )
    }
}