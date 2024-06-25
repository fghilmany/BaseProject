package com.fghilmany.baseproject.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fghilmany.moviedetail.ui.navigation.detailMovieScreen
import com.fghilmany.moviedetail.ui.navigation.navigateToMovieDetail
import com.fghilmany.movielist.ui.navigation.moviesGraph
import com.fghilmany.movielist.ui.navigation.moviesGraphRoute

@Composable
fun MainAppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = moviesGraphRoute
) {
    NavHost(
        navController = navHostController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        moviesGraph(
            onMovieClick = navHostController::navigateToMovieDetail,
        ) {
            detailMovieScreen(
                popBackStack = navHostController::popBackStack,
                navHostController = navHostController
            )
        }
    }
}