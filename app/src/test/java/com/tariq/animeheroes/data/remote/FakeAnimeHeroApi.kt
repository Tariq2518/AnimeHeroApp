package com.tariq.animeheroes.data.remote

import com.tariq.animeheroes.domain.model.AnimeApiResponse
import com.tariq.animeheroes.domain.model.AnimeHero


class FakeAnimeHeroApi : AnimeHeroApi {

    private val heroes = listOf(
        AnimeHero(
            id = 1,
            name = "Vegeta",
            image = "/images/vegeta.jpg",
            about = "Vegeta (ベジータ Bejīta), more specifically Vegeta IV (ベジータ四世 Bejīta Yonsei),[7] recognized as Prince Vegeta (ベジータ王子 Bejīta Ōji), is the prince of the fallen Saiyan race and the husband of Bulma, the father of Trunks and Bulla, the eldest son of King Vegeta, as well as one of the main characters of the Dragon Ball series.",
            rating = 5.0,
            power = 99,
            month = "May",
            day = "10th",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()
        ),
        AnimeHero(
            id = 2,
            name = "Goku",
            image = "/images/goku.jpg",
            about = "Kakarot, better known as Son Goku, is the main protagonist of the Dragon Ball franchise.",
            rating = 5.0,
            power = 99,
            month = "April",
            day = "16th",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()
        ),
        AnimeHero(
            id = 3,
            name = "Mr. L",
            image = "/images/mrl.jpg",
            about = "L (エル, Eru) is a world-renowned detective who takes on the challenge of catching the mass murderer known as Kira. In his investigation, L becomes suspicious of Light Yagami and makes it his goal to prove that Light is Kira.",
            rating = 5.0,
            power = 98,
            month = "July",
            day = "30th",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf()
        )
    )

    override suspend fun getAllAnimeHeroes(page: Int): AnimeApiResponse {
        return AnimeApiResponse(
            success = false
        )
    }

    override suspend fun searchAnimeHeroes(name: String): AnimeApiResponse {
        val searchedHeroes = findHeroes(name = name)
        return AnimeApiResponse(
            success = true,
            message = "ok",
            animeHeroes = searchedHeroes
        )
    }

    private fun findHeroes(name: String): List<AnimeHero> {
        val founded = mutableListOf<AnimeHero>()
        return if (name.isNotEmpty()) {
            heroes.forEach { hero ->
                if (hero.name.lowercase().contains(name.lowercase())) {
                    founded.add(hero)
                }
            }
            founded
        } else {
            emptyList()
        }
    }
}