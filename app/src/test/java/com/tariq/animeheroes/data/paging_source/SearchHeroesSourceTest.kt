package com.tariq.animeheroes.data.paging_source

import androidx.paging.PagingSource.LoadParams
import androidx.paging.PagingSource.LoadResult
import com.tariq.animeheroes.data.remote.AnimeHeroApi
import com.tariq.animeheroes.data.remote.FakeAnimeHeroApi
import com.tariq.animeheroes.domain.model.AnimeHero
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class SearchHeroesSourceTest {

    private lateinit var animeHeroApi: AnimeHeroApi
    private lateinit var heroes: List<AnimeHero>

    @Before
    fun setup() {
        animeHeroApi = FakeAnimeHeroApi()
        heroes = listOf(
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
    }

    @Test
    fun `Search api with existing hero name, expect single hero result, assert LoadResult_Page`() =
        runTest {
            val heroSource = SearchAnimeHeroesSource(animeHeroApi = animeHeroApi, query = "Vegeta")
            assertEquals<LoadResult<Int, AnimeHero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first()),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with existing hero name, expect multiple hero result, assert LoadResult_Page`() =
        runTest {
            val heroSource = SearchAnimeHeroesSource(animeHeroApi = animeHeroApi, query = "Ve")
            assertEquals<LoadResult<Int, AnimeHero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first()),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with empty hero name, assert empty heroes list and LoadResult_Page`() =
        runTest {
            val heroSource = SearchAnimeHeroesSource(animeHeroApi = animeHeroApi, query = "")
            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )

            val result = animeHeroApi.searchAnimeHeroes("").animeHeroes

            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }

    @Test
    fun `Search api with non_existing hero name, assert empty heroes list and LoadResult_Page`() =
        runTest {
            val heroSource = SearchAnimeHeroesSource(animeHeroApi = animeHeroApi, query = "Unknown")
            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )

            val result = animeHeroApi.searchAnimeHeroes("Unknown").animeHeroes

            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }

}