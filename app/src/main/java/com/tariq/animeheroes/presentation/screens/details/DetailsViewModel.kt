package com.tariq.animeheroes.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tariq.animeheroes.domain.model.AnimeHero
import com.tariq.animeheroes.domain.use_cases.UseCases
import com.tariq.animeheroes.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val userCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedAnimeHero: MutableState<AnimeHero?> = mutableStateOf(null)
    val selectedAnimeHero: State<AnimeHero?> = _selectedAnimeHero

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val animeHeroId = savedStateHandle.get<Int>(Constants.HERO_SCREEN_ARGUMENT_KEY)
            _selectedAnimeHero.value = animeHeroId?.let { userCases.getSelectedHeroUseCase(animeHeroId = it) }
        }
    }

}