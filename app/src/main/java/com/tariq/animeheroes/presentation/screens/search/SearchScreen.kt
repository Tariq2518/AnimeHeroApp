package com.tariq.animeheroes.presentation.screens.search

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            SearchTopBar(
                text = "",
                onTextChange = {},
                onSearchClicked = {}
            ) {

            }
        },
        content = {
            Log.i("TAG", "SearchScreen: $it")
        }
    )

}