package com.tariq.animeheroes.presentation.common

import android.media.Rating
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.tariq.animeheroes.R
import com.tariq.animeheroes.domain.model.AnimeHero
import com.tariq.animeheroes.navigation.Screen
import com.tariq.animeheroes.presentation.components.AnimeShimmerEffect
import com.tariq.animeheroes.presentation.components.RatingWidget
import com.tariq.animeheroes.ui.theme.ANIME_HERO_ITEM_HEIGHT
import com.tariq.animeheroes.ui.theme.LARGE_PADDING
import com.tariq.animeheroes.ui.theme.MEDIUM_PADDING
import com.tariq.animeheroes.ui.theme.SMALL_PADDING
import com.tariq.animeheroes.ui.theme.topAppBarContentColor
import com.tariq.animeheroes.utils.Constants.LOCAL_BASE_URL

@Composable
fun ListContent(
    animeHeroes: LazyPagingItems<AnimeHero>,
    navController: NavHostController
) {

    val loadingState = handlePagingResult(animeHeroes = animeHeroes)
    if (loadingState) {
        LazyColumn(
            contentPadding = PaddingValues(all = SMALL_PADDING),
            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
        ) {
            items(
                items = animeHeroes,
                key = { animeHero: AnimeHero ->
                    animeHero.id
                }
            ) { animeHero: AnimeHero? ->
                animeHero?.let {
                    AnimeHeroItem(
                        animeHero = it,
                        navController = navController
                    )
                }
            }
        }
    }

}


@OptIn(ExperimentalCoilApi::class)
@Composable
private fun AnimeHeroItem(
    animeHero: AnimeHero,
    navController: NavHostController
) {

    val painter = rememberImagePainter(data = "$LOCAL_BASE_URL${animeHero.image}") {
        placeholder(R.drawable.ic_placeholder)
        error(R.drawable.ic_placeholder)
    }

    Box(
        modifier = Modifier
            .height(ANIME_HERO_ITEM_HEIGHT)
            .clickable {
                navController.navigate(Screen.HeroScreen.passAnimeHeroId(animeHeroId = animeHero.id))
            },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(
            shape = RoundedCornerShape(size = LARGE_PADDING)
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = stringResource(R.string.hero_image),
                contentScale = ContentScale.Crop
            )

        }

        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .padding(all = MEDIUM_PADDING)
            ) {
                Text(
                    text = animeHero.name,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = animeHero.about,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = Modifier.padding(top = SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    RatingWidget(
                        modifier = Modifier.padding(end = SMALL_PADDING),
                        rating = animeHero.rating
                    )
                    Text(
                        text = "(${animeHero.rating})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium)
                    )
                }
            }

        }
    }

}

@Composable
fun handlePagingResult(
    animeHeroes: LazyPagingItems<AnimeHero>
): Boolean {
    animeHeroes.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                AnimeShimmerEffect()
                false
            }

            this.itemCount < 1 -> {
                EmptyScreen()
                false
            }

            error != null -> {
                EmptyScreen(error = error, animeHeroes = this)
                false
            }

            else -> true
        }
    }
}

@Composable
@Preview
private fun AnimeHeroItemPreview() {
    AnimeHeroItem(
        animeHero = AnimeHero(
            id = 1,
            name = "Vegeta",
            image = "/images/vegeta.jpg",
            about = "Vegeta (ベジータ Bejīta), more specifically Vegeta IV (ベジータ四世 Bejīta Yonsei),[7] recognized as Prince Vegeta (ベジータ王子 Bejīta Ōji), is the prince of the fallen Saiyan race and the husband of Bulma, the father of Trunks and Bulla, the eldest son of King Vegeta, as well as one of the main characters of the Dragon Ball series.",
            rating = 5.0,
            power = 99,
            month = "May",
            day = "10th",
            family = listOf(
                "Tarble",
                "Bulma",
                "Trunks",
                "Bulla",
                "Mr. & Mrs. Briefs"
            ),
            abilities = listOf(
                "Super Siyan",
                "Pride",
                "Coba",
                "Otta",
                "Frost"
            ),
            natureTypes = listOf(
                "Cold",
                "Merciless",
                "Aggressive",
                "Royal",
                "Arrogant"
            )
        ),
        navController = rememberNavController()
    )
}
