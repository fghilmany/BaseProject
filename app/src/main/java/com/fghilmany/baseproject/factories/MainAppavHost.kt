package com.fghilmany.baseproject.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fghilmany.baseproject.feature.moviedetail.ui.navigation.detailMovieScreen
import com.fghilmany.baseproject.feature.moviedetail.ui.navigation.navigateToMovieDetail
import com.fghilmany.baseproject.feature.movielist.ui.navigation.moviesGraph
import com.fghilmany.baseproject.feature.movielist.ui.navigation.moviesGraphRoute

@Composable
fun MainAppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = moviesGraphRoute,
    mainComponent: MainComponent
) {
    NavHost(
        navController = navHostController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        moviesGraph(
            mainComponent = mainComponent,
            onMovieClick = navHostController::navigateToMovieDetail,
        ) {
            detailMovieScreen(
                mainComponent = mainComponent,
                popBackStack = navHostController::popBackStack,
                navHostController = navHostController
            )
        }
    }
}