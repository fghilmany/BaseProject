package com.fghilmany.baseproject.feature.moviedetail.ui.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fghilmany.baseproject.factories.MainComponent
import com.fghilmany.baseproject.feature.moviedetail.presentation.DetailMovieViewModel
import com.fghilmany.baseproject.feature.moviedetail.ui.DetailMovieRoute

const val detailMovieRoute = "movie_detail_route"
const val MOVIE_ID = "movie_id"

fun NavController.navigateToMovieDetail(movieId: Int, navOptions: NavOptions? = null) {
    this.currentBackStackEntry?.savedStateHandle?.set(key = MOVIE_ID, value = movieId)
    this.navigate(detailMovieRoute, navOptions)
}

fun NavGraphBuilder.detailMovieScreen(
    mainComponent: MainComponent,
    popBackStack: () -> Unit,
    navHostController: NavHostController
) {
    composable(
        route = detailMovieRoute,
    ) {
        val viewModel: DetailMovieViewModel = viewModel {
            mainComponent.detailMovieViewModel()
        }
        val movieId = navHostController.previousBackStackEntry?.savedStateHandle?.get<Int>(MOVIE_ID)

        viewModel.setMovieId(movieId ?: 12)
        DetailMovieRoute(
            viewModel = viewModel,
            popBackStack = popBackStack
        )
    }
}