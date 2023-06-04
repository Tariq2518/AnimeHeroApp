package com.tariq.animeheroes.navigation

sealed class Screen(val route: String){
    object SplashScreen: Screen("splash_screen")
    object OnBoardingScreen: Screen("onboarding_screen")
    object HomeScreen: Screen("home_screen")
    object HeroScreen: Screen("hero_screen/{animeHeroId}"){
        fun passAnimeHeroId(animeHeroId: Int): String{
            return "hero_screen/$animeHeroId"
        }
    }
    object SearchScreen: Screen("search_screen")
}
