package com.tariq.animeheroes.domain.model

import androidx.annotation.DrawableRes
import com.tariq.animeheroes.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
){
    object First: OnBoardingPage(
        image = R.drawable.greetings,
        "Welcome",
        "Are you Anime fan? Because if you are we have a great news for you!"
    )

    object Second: OnBoardingPage(
        image = R.drawable.explore,
        "Explore",
        "Find your favourite heroes and learn exciting things about your heroes"
    )

    object Third: OnBoardingPage(
        image = R.drawable.power,
        "Power",
        "Check out your heroes power and see how much strong are they"
    )
}
