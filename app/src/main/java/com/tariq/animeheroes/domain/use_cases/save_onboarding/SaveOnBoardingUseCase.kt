package com.tariq.animeheroes.domain.use_cases.save_onboarding

import com.tariq.animeheroes.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(onCompleted: Boolean){
        repository.saveOnBoardingState(onCompleted = onCompleted)
    }
}