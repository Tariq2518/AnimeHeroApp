package com.tariq.animeheroes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)
val StarColor = Color(0xFFFFC94D)

val ShimmerLightGray = Color(0xFFF1F1F1)
val ShimmerMediumGray = Color(0xFFE3E3E3)
val ShimmerDarkGray = Color(0xFF1D1D1D)

val Colors.onBoardingScreenBackgroundColor
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else Color.Black

val Colors.titleColor
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.DarkGray else Color.LightGray

val Colors.descriptionColor
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.DarkGray.copy(alpha = 0.5f)
    else Color.LightGray.copy(alpha = 0.5f)