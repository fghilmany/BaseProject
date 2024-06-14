package com.fghilmany.movielist.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fghilmany.common.component.LoadingContent
import com.fghilmany.common.component.PullRefresh
import com.fghilmany.common.ui.theme.Purple40
import com.fghilmany.movielist.presentation.MoviesViewModel
import com.fghilmany.movielist.ui.component.ListMovie

@Composable
fun MoviesRoute(viewModel: MoviesViewModel, onNavigateToMovieDetail: (Int) -> Unit) {

    val listMovieUiState by viewModel.moviesUiState.collectAsStateWithLifecycle()

    Log.d("loadMovies", "$listMovieUiState")

    MoviesScreen(
        listMovieUiState = listMovieUiState,
        onRefreshMovies = viewModel::loadMovies,
        onNavigateToMovieDetail = onNavigateToMovieDetail
    )
}
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MoviesScreen(
    modifier: Modifier = Modifier,
    listMovieUiState: com.fghilmany.movielist.presentation.MoviesUiState,
    onRefreshMovies: () -> Unit,
    onNavigateToMovieDetail: (Int) -> Unit
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = listMovieUiState.isLoading,
        onRefresh = onRefreshMovies
    )

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Movie LIst",
                    maxLines = 1,
                    color = Color.White
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Purple40
            )
        )
    }, content = {
        val contentModifier = modifier
            .padding(it)
            .fillMaxSize()
            .pullRefresh(pullRefreshState)

        LoadingContent(
            pullRefreshState = pullRefreshState,
            loading = listMovieUiState.isLoading,
            empty = when (listMovieUiState) {
                is com.fghilmany.movielist.presentation.MoviesUiState.HasMovies -> false
                is com.fghilmany.movielist.presentation.MoviesUiState.NoMovies -> listMovieUiState.isLoading
            },
            emptyContent = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    PullRefresh(
                        loading = listMovieUiState.isLoading,
                        pullRefreshState = pullRefreshState,
                        Modifier.align(Alignment.TopCenter)
                    )
                }
            },
            content = {
                when (listMovieUiState) {
                    is com.fghilmany.movielist.presentation.MoviesUiState.HasMovies -> {
                        ListMovie(
                            contentModifier = contentModifier,
                            items = listMovieUiState.listMovies,
                            onItemClick = { movieId ->
                                onNavigateToMovieDetail(movieId)
                            }
                        )
                    }

                    is com.fghilmany.movielist.presentation.MoviesUiState.NoMovies -> {
                        if (listMovieUiState.failed.isEmpty()) {
                            Box(
                                modifier = modifier
                                    .fillMaxSize()
                                    .wrapContentSize(Alignment.Center)
                            ) {
                                Text(
                                    "List Movies Empty",
                                )
                            }
                        }
                    }
                }
            })

        Box(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                listMovieUiState.failed,
            )
        }
    })
}
