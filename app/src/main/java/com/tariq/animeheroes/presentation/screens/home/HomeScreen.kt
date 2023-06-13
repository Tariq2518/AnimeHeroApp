package com.tariq.animeheroes.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tariq.animeheroes.presentation.common.ListContent
import com.tariq.animeheroes.presentation.components.RatingWidget
import com.tariq.animeheroes.ui.theme.LARGE_PADDING
import com.tariq.animeheroes.ui.theme.Purple700
import com.tariq.animeheroes.ui.theme.homeScreenBackgroundColor
import com.tariq.animeheroes.ui.theme.onBoardingScreenBackgroundColor
import kotlinx.coroutines.flow.collect

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
    if (isSystemInDarkTheme()) {
        systemUiController.setSystemBarsColor(
            color = Color.Black, darkIcons = false
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = Purple700, darkIcons = false
        )
    }

    val allAnimeHeroes = homeViewModel.getAllAnimeHeroes.collectAsLazyPagingItems()

    Scaffold(
        backgroundColor = MaterialTheme.colors.homeScreenBackgroundColor,
        topBar = {
            HomeTopBar(onSearchClicked = {})
        },
        content = {
            Log.i("TAG", "HomeScreen: $it")
            ListContent(
                animeHeroes = allAnimeHeroes,
                navController = navController
            )
        }
    )

}