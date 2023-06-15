package com.tariq.animeheroes.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tariq.animeheroes.presentation.screens.home.HomeScreen
import com.tariq.animeheroes.presentation.screens.onboarding.OnBoardingScreen
import com.tariq.animeheroes.presentation.screens.search.SearchScreen
import com.tariq.animeheroes.presentation.screens.splash.SplashScreen
import com.tariq.animeheroes.utils.Constants.HERO_SCREEN_ARGUMENT_KEY

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.HeroScreen.route,
            arguments = listOf(navArgument(HERO_SCREEN_ARGUMENT_KEY) {
                type = NavType.IntType
            }
            )
        ) {

        }
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
    }
}