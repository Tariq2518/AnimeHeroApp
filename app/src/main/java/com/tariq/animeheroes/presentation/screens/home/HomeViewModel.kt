package com.tariq.animeheroes.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.tariq.animeheroes.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    userCases: UseCases
) : ViewModel() {
    val getAllAnimeHeroes = userCases.getAllAnimeHeroesUserCase()
}