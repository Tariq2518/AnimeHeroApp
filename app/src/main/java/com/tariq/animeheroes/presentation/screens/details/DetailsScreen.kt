package com.tariq.animeheroes.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tariq.animeheroes.utils.Constants.LOCAL_BASE_URL
import com.tariq.animeheroes.utils.PaletteGenerator
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailsScreen(
    navController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {

    val selectedAnimeHero by detailsViewModel.selectedAnimeHero.collectAsState()
    val colorPalette by detailsViewModel.colorPalette

    if (colorPalette.isNotEmpty()) {
        DetailsContent(
            navController = navController,
            selectedAnimeHero = selectedAnimeHero,
            colors = colorPalette
        )
    } else {
        detailsViewModel.generateColorPalette()
    }

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        detailsViewModel.uiEvent.collectLatest { event ->
            when (event) {
                is UiEvent.GenerateColorPalette -> {
                    val bitmap = PaletteGenerator.convertImageUrlToBitmap(
                        imageUrl = "$LOCAL_BASE_URL${selectedAnimeHero?.image}",
                        context = context
                    )
                    if (bitmap != null) {
                        detailsViewModel.setColorPalette(
                            colors = PaletteGenerator.extractColorsFromBitmap(
                                bitmap = bitmap
                            )
                        )
                    }
                }
            }
        }
    }


}