@file:OptIn(ExperimentalMaterialApi::class)

package com.tariq.animeheroes.presentation.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.tariq.animeheroes.R
import com.tariq.animeheroes.domain.model.AnimeHero
import com.tariq.animeheroes.presentation.components.InfoBox
import com.tariq.animeheroes.presentation.components.OrderedList
import com.tariq.animeheroes.ui.theme.LARGE_PADDING
import com.tariq.animeheroes.ui.theme.MEDIUM_PADDING
import com.tariq.animeheroes.ui.theme.SMALL_PADDING
import com.tariq.animeheroes.ui.theme.titleColor
import com.tariq.animeheroes.utils.Constants.LOCAL_BASE_URL
import kotlin.math.absoluteValue
import android.graphics.Color.parseColor
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.BottomSheetValue.Collapsed
import androidx.compose.material.BottomSheetValue.Expanded
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.request.ImageRequest
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tariq.animeheroes.ui.theme.EXTRA_LARGE_PADDING

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsContent(
    navController: NavHostController,
    selectedAnimeHero: AnimeHero?,
    colors: Map<String, String>
) {

    var vibrant by remember { mutableStateOf("#000000") }
    var darkVibrant by remember { mutableStateOf("#000000") }
    var onDarkVibrant by remember { mutableStateOf("#ffffff") }

    LaunchedEffect(key1 = selectedAnimeHero) {
        vibrant = colors["vibrant"]!!
        darkVibrant = colors["darkVibrant"]!!
        onDarkVibrant = colors["onDarkVibrant"]!!
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = Color(parseColor(darkVibrant))
    )

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = Expanded)
    )

    val currentSheerFraction = scaffoldState.currentSheetFraction

    val radiusAnim by animateDpAsState(
        targetValue = if (currentSheerFraction == 1f) EXTRA_LARGE_PADDING else 0.dp
    )

    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(
            topStart = radiusAnim,
            topEnd = radiusAnim
        ),
        scaffoldState = scaffoldState,
        sheetPeekHeight = 140.dp,
        sheetContent = {
            selectedAnimeHero?.let {
                BottomSheetContent(
                    selectedAnimeHero = it,
                    infoBoxIconColor = Color(parseColor(vibrant)),
                    sheetBackgroundColor = Color(parseColor(darkVibrant)),
                    contentColor = Color(parseColor(onDarkVibrant))
                )
            }
        },
        content = {
            selectedAnimeHero?.let { animeHero ->
                BackgroundContent(
                    animeHeroImage = animeHero.image,
                    imageFraction = currentSheerFraction,
                    backgroundColor = Color(parseColor(darkVibrant)),
                    onCloseClicked = {
                        navController.popBackStack()
                    }
                )
            }
        }
    )
}

var targetValue by mutableStateOf(Expanded)

fun observeTargetValue(bottomSheetState: BottomSheetScaffoldState) {
    targetValue = bottomSheetState.bottomSheetState.currentValue
}

@ExperimentalMaterialApi
val BottomSheetScaffoldState.currentSheetFraction: Float
    get() {

        val fraction = bottomSheetState.progress
        observeTargetValue(this)
        //val targetValue = if (bottomSheetState.progress in 5f..9f) Expanded else Collapsed
        val targetValue = targetValue
        val currentValue = bottomSheetState.currentValue

        return when {
            currentValue == Collapsed && targetValue == Collapsed -> 1f
            currentValue == Expanded && targetValue == Expanded -> 0f
            currentValue == Collapsed && targetValue == Expanded -> 1f - fraction
            currentValue == Expanded && targetValue == Collapsed -> 0f + fraction
            else -> fraction
        }
    }


@Composable
fun BottomSheetContent(
    selectedAnimeHero: AnimeHero,
    infoBoxIconColor: Color = MaterialTheme.colors.primary,
    sheetBackgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = MaterialTheme.colors.titleColor
) {

    Column(
        modifier = Modifier
            .background(sheetBackgroundColor)
            .padding(all = LARGE_PADDING)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = LARGE_PADDING),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(32.dp)
                    .weight(2f),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.logo_icon),
                tint = contentColor
            )

            Text(
                modifier = Modifier
                    .weight(8f),
                text = selectedAnimeHero.name,
                color = contentColor,
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MEDIUM_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoBox(
                icon = painterResource(id = R.drawable.ic_bolt),
                iconColor = infoBoxIconColor,
                bigText = "${selectedAnimeHero.power}",
                smallText = stringResource(R.string.power),
                textColor = contentColor
            )

            InfoBox(
                icon = painterResource(id = R.drawable.ic_calendar),
                iconColor = infoBoxIconColor,
                bigText = selectedAnimeHero.month,
                smallText = stringResource(R.string.month),
                textColor = contentColor
            )

            InfoBox(
                icon = painterResource(id = R.drawable.ic_cake),
                iconColor = infoBoxIconColor,
                bigText = selectedAnimeHero.day,
                smallText = stringResource(R.string.birthday),
                textColor = contentColor
            )

        }

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(R.string.about),
            color = contentColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .padding(bottom = MEDIUM_PADDING),
            text = selectedAnimeHero.about,
            color = contentColor,
            fontSize = MaterialTheme.typography.body1.fontSize,
            maxLines = 7
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            OrderedList(
                title = stringResource(R.string.family),
                items = selectedAnimeHero.family,
                textColor = contentColor
            )

            OrderedList(
                title = stringResource(R.string.abilities),
                items = selectedAnimeHero.abilities,
                textColor = contentColor
            )

            OrderedList(
                title = stringResource(R.string.nature_types),
                items = selectedAnimeHero.natureTypes,
                textColor = contentColor
            )

        }

    }

}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun BackgroundContent(
    animeHeroImage: String,
    imageFraction: Float = 1f,
    backgroundColor: Color = MaterialTheme.colors.surface,
    onCloseClicked: () -> Unit
) {

    val imageUrl = "$LOCAL_BASE_URL$animeHeroImage"
    val painter = rememberImagePainter(imageUrl) {
        error(R.drawable.ic_placeholder)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)

    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = imageFraction + 0.4f)
                .align(Alignment.TopStart),
            painter = painter,
            contentDescription = stringResource(R.string.anime_hero_image),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                modifier = Modifier.padding(all = SMALL_PADDING),
                onClick = { onCloseClicked.invoke() }
            ) {
                Icon(
                    modifier = Modifier
                        .size(32.dp),
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(id = R.string.close_icon_button),
                    tint = Color.White
                )

            }

        }


    }

}