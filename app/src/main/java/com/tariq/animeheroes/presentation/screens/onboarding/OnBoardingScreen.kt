package com.tariq.animeheroes.presentation.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tariq.animeheroes.R
import com.tariq.animeheroes.domain.model.OnBoardingPage
import com.tariq.animeheroes.navigation.Screen
import com.tariq.animeheroes.ui.theme.EXTRA_LARGE_PADDING
import com.tariq.animeheroes.ui.theme.Purple700
import com.tariq.animeheroes.ui.theme.SMALL_PADDING
import com.tariq.animeheroes.ui.theme.descriptionColor
import com.tariq.animeheroes.ui.theme.onBoardingScreenBackgroundColor
import com.tariq.animeheroes.ui.theme.titleColor
import com.tariq.animeheroes.utils.Constants.ON_BOARDING_PAGE_COUNT


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavHostController
) {
    val listOfPages = listOf(
        OnBoardingPage.First, OnBoardingPage.Second, OnBoardingPage.Third
    )
    val systemUiController = rememberSystemUiController()
    if (isSystemInDarkTheme()){
        systemUiController.setSystemBarsColor(
            color = Color.Black, darkIcons = false
        )
    }else{
        systemUiController.setSystemBarsColor(
            color = Purple700, darkIcons = false
        )
    }

    val pagerState = rememberPagerState(0, 0f) { ON_BOARDING_PAGE_COUNT }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.onBoardingScreenBackgroundColor)
    ) {
        HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { page ->
            PagerScreen(onBoardingPage = listOfPages[page])
        }
    }

}

@Composable
private fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(R.string.on_boarding_image)
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,
            color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = MaterialTheme.colors.descriptionColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )

    }

}