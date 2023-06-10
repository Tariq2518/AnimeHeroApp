package com.tariq.animeheroes.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tariq.animeheroes.ui.theme.Purple700
import com.tariq.animeheroes.ui.theme.homeScreenBackgroundColor
import com.tariq.animeheroes.ui.theme.onBoardingScreenBackgroundColor

@Composable
fun HomeScreen(
    navController: NavHostController
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
    Scaffold(
        backgroundColor = MaterialTheme.colors.homeScreenBackgroundColor,
        topBar = {
            HomeTopBar(onSearchClicked = {})
        }
    ) {
        Log.i("TAG", "HomeScreen: $it")
    }

}