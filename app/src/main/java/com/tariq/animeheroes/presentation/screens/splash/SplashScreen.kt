package com.tariq.animeheroes.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tariq.animeheroes.R
import com.tariq.animeheroes.navigation.Screen
import com.tariq.animeheroes.ui.theme.Purple500
import com.tariq.animeheroes.ui.theme.Purple700

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {

    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()

    val rotate = remember { Animatable(0f) }
    LaunchedEffect(key1 = true) {
        rotate.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
        navController.popBackStack()
        if (onBoardingCompleted) {
            navController.navigate(Screen.HomeScreen.route)
        } else {
            navController.navigate(Screen.OnBoardingScreen.route)
        }
    }

    Splash(rotate.value)
}


@Composable
private fun Splash(degrees: Float) {
    val systemUiController = rememberSystemUiController()

    if (isSystemInDarkTheme()) {
        systemUiController.setSystemBarsColor(
            color = Color.Black, darkIcons = false
        )

        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(degrees),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(
                    R.string.splash_screen_logo
                )
            )

        }
    } else {
        systemUiController.setSystemBarsColor(
            color = Purple700, darkIcons = false
        )

        Box(
            modifier = Modifier
                .background(Brush.verticalGradient(listOf(Purple700, Purple500)))
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(degrees),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.splash_screen_logo)
            )

        }
    }
}


@Composable
@Preview
private fun SplashScreenPreview() {
    Splash(degrees = 0f)
}