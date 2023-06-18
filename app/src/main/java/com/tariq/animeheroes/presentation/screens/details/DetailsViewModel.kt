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
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val userCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedAnimeHero: MutableStateFlow<AnimeHero?> = MutableStateFlow(null)
    val selectedAnimeHero: StateFlow<AnimeHero?> = _selectedAnimeHero

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val animeHeroId = savedStateHandle.get<Int>(Constants.HERO_SCREEN_ARGUMENT_KEY)
            _selectedAnimeHero.value = animeHeroId?.let { userCases.getSelectedHeroUseCase(animeHeroId = it) }
        }
    }

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent.asSharedFlow()

    private val _colorPalette: MutableState<Map<String, String>> = mutableStateOf(mapOf())
    val colorPalette: State<Map<String, String>> = _colorPalette

    fun generateColorPalette() {
        viewModelScope.launch {
            _uiEvent.emit(UiEvent.GenerateColorPalette)
        }
    }

    fun setColorPalette(colors: Map<String, String>){
        _colorPalette.value = colors
    }

}

sealed class UiEvent {
    object GenerateColorPalette : UiEvent()
}