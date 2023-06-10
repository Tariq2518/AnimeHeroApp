@file:OptIn(InternalComposeApi::class)

package com.tariq.animeheroes.presentation.screens.home

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.tariq.animeheroes.R
import com.tariq.animeheroes.ui.theme.topAppBarBackgroundColor
import com.tariq.animeheroes.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit
) {

  TopAppBar(
      title = {
          Text(
              text = "Explore",
              color = MaterialTheme.colors.topAppBarContentColor
          )
      },
      backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
      actions = {
          IconButton(onClick = onSearchClicked) {
              Icon(
                  imageVector = Icons.Default.Search,
                  contentDescription = stringResource(R.string.search_icon),
                  tint = Color.LightGray
              )
          }
      }
  )
}