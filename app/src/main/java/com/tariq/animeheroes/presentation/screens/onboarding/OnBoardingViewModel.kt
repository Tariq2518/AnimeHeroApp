package com.tariq.animeheroes.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tariq.animeheroes.domain.use_cases.UseCases
import com.tariq.animeheroes.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    fun saveOnBoardingState(onCompleted: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            useCases.saveOnBoardingUseCase(onCompleted = onCompleted)
        }
    }
}