package com.tariq.animeheroes.data.remote

import com.tariq.animeheroes.domain.model.AnimeApiResponse
import com.tariq.animeheroes.domain.model.AnimeHero
import java.io.IOException

class FakeAnimeHeroApi2 : AnimeHeroApi {


    val animeHeroes: Map<Int, List<AnimeHero>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5,
            6 to page6
        )
    }
    var page1 = listOf(
        AnimeHero(
            id = 1,
            name = "Vegeta",
            image = "/images/vegeta.jpg",
            about = "Vegeta (ベジータ Bejīta), more specifically Vegeta IV (ベジータ四世 Bejīta Yonsei),[7] recognized as Prince Vegeta (ベジータ王子 Bejīta Ōji), is the prince of the fallen Saiyan race and the husband of Bulma, the father of Trunks and Bulla, the eldest son of King Vegeta, as well as one of the main characters of the Dragon Ball series.",
            rating = 5.0,
            power = 99,
            month = "May",
            day = "10th",
            family = listOf(
                "Tarble",
                "Bulma",
                "Trunks",
                "Bulla",
                "Mr. & Mrs. Briefs"
            ),
            abilities = listOf(
                "Super Siyan",
                "Pride",
                "Coba",
                "Otta",
                "Frost"
            ),
            natureTypes = listOf(
                "Cold",
                "Merciless",
                "Aggressive",
                "Royal",
                "Arrogant"
            )
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
            family = listOf(
                "Bardock",
                "Gine",
                "Chi-Chi",
                "Gohan",
                "Pan"
            ),
            abilities = listOf(
                "Saiyan Physiology",
                "Infant Siyan",
                "Ultra Instinct",
                "Kamehameha",
                "Beyond God Instant Kamehameha"
            ),
            natureTypes = listOf(
                "Immeasurable",
                "Ultimate Defender",
                "Athleticism",
                "Dexterity",
                "Senses"
            )
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
            family = listOf(
                "Hideki Ryuga",
                "Ryuzaki",
                "Erarudo",
                "Asahi",
                "Suzuki"
            ),
            abilities = listOf(
                "Knowledge",
                "Creativity",
                "Emotional",
                "Sweet Tooth",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Childish",
                "Social",
                "Senses",
                "Detective"
            )
        )
    )
    val page2 = listOf(
        AnimeHero(
            id = 4,
            name = "Sasuke",
            image = "/images/sasuke.jpg",
            about = "Sasuke Uchiha (うちはサスケ, Uchiha Sasuke) is one of the last surviving members of Konohagakure's Uchiha clan. After his older brother, Itachi, slaughtered their clan, Sasuke made it his mission in life to avenge them by killing Itachi. He is added to Team 7 upon becoming a ninja and, through competition with his rival and best friend, Naruto Uzumaki.",
            rating = 5.0,
            power = 98,
            month = "July",
            day = "23rd",
            family = listOf(
                "Fugaku",
                "Mikoto",
                "Itachi",
                "Sarada",
                "Sakura"
            ),
            abilities = listOf(
                "Sharingan",
                "Rinnegan",
                "Sussano",
                "Amateratsu",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Lightning",
                "Fire",
                "Wind",
                "Earth",
                "Water"
            )
        ),
        AnimeHero(
            id = 5,
            name = "Naruto",
            image = "/images/naruto.jpg",
            about = "Naruto Uzumaki (うずまきナルト, Uzumaki Naruto) is a shinobi of Konohagakure's Uzumaki clan. He became the jinchūriki of the Nine-Tails on the day of his birth — a fate that caused him to be shunned by most of Konoha throughout his childhood. After joining Team Kakashi, Naruto worked hard to gain the village's acknowledgement all the while chasing his dream to become Hokage.",
            rating = 5.0,
            power = 98,
            month = "Oct",
            day = "10th",
            family = listOf(
                "Minato",
                "Kushina",
                "Boruto",
                "Himawari",
                "Hinata"
            ),
            abilities = listOf(
                "Rasengan",
                "Rasen-Shuriken",
                "Shadow Clone",
                "Senin Mode"
            ),
            natureTypes = listOf(
                "Wind",
                "Earth",
                "Lava",
                "Fire"
            )
        ),
        AnimeHero(
            id = 6,
            name = "Sakura",
            image = "/images/sakura.jpg",
            about = "Sakura Uchiha (うちはサクラ, Uchiha Sakura, née Haruno (春野)) is a kunoichi of Konohagakure. When assigned to Team 7, Sakura quickly finds herself ill-prepared for the duties of a shinobi. However, after training under the Sannin Tsunade, she overcomes this, and becomes recognised as one of the greatest medical-nin in the world.",
            rating = 4.5,
            power = 92,
            month = "Mar",
            day = "28th",
            family = listOf(
                "Kizashi",
                "Mebuki",
                "Sarada",
                "Sasuke"
            ),
            abilities = listOf(
                "Chakra Control",
                "Medical Ninjutsu",
                "Strength",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Earth",
                "Water",
                "Fire"
            )
        )
    )
    val page3 = listOf(
        AnimeHero(
            id = 7,
            name = "Boruto",
            image = "/images/boruto.png",
            about = "Boruto Uzumaki (うずまきボルト, Uzumaki Boruto) is a shinobi from Konohagakure's Uzumaki clan and a direct descendant of the Hyūga clan through his mother. While initially resentful of his father and his absence since becoming Hokage, Boruto eventually comes to respect his father and duties.",
            rating = 4.9,
            power = 95,
            month = "Mar",
            day = "27th",
            family = listOf(
                "Naruto",
                "Hinata",
                "Hanabi",
                "Himawari",
                "Kawaki"
            ),
            abilities = listOf(
                "Karma",
                "Jogan",
                "Rasengan",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Water"
            )
        ),
        AnimeHero(
            id = 8,
            name = "Sarada",
            image = "/images/sarada.jpg",
            about = "Sarada Uchiha (うちはサラダ, Uchiha Sarada) is a kunoichi from Konohagakure's Uchiha clan. Because she was raised only by her mother without having her father around, Sarada initially struggles to understand who she is or what she's supposed to be. After meeting him with the help of Naruto Uzumaki, Sarada comes to believe that she is defined by the connections she has with others, and as a member of Team Konohamaru, she seeks to someday become Hokage so that she can connect with as many people as possible.",
            rating = 4.9,
            power = 95,
            month = "Mar",
            day = "31st",
            family = listOf(
                "Sasuke Uchiha",
                "Sakura Uchiha"
            ),
            abilities = listOf(
                "Sharingan",
                "Strength",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire"
            )
        ),
        AnimeHero(
            id = 9,
            name = "Mitsuki",
            image = "/images/mitsuki.jpg",
            about = "Mitsuki (ミツキ, Mitsuki) is a synthetic human that was created as a partial clone of Orochimaru. Immigrating to Konohagakure to confirm whether or not Boruto Uzumaki was his \"sun\", he became a shinobi and was placed on Team Konohamaru. Mitsuki was created as a clone of Orochimaru, being cultivated from the same embryo as at least one older \"Mitsuki\", and raised in a test tube.",
            rating = 4.9,
            power = 95,
            month = "Jul",
            day = "25th",
            family = listOf(
                "Orochimaru",
                "Log"
            ),
            abilities = listOf(
                "Senin Mode",
                "Transformation",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind"
            )
        )
    )
    val page4 = listOf(
        AnimeHero(
            id = 10,
            name = "Kawaki",
            image = "/images/kawaki.jpg",
            about = "Kawaki (カワキ, Kawaki) is a child raised by Kara to be the future vessel for Isshiki Ōtsutsuki and the key to the fulfilment of their greatest wish.[1] After being brought to Konohagakure by Team 7, he is taken in by Naruto Uzumaki who raises him as his own, during which he develops a brotherly bond with Boruto Uzumaki to solve the mystery of the Kāma.",
            rating = 4.2,
            power = 92,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Kokatsu"
            ),
            abilities = listOf(
                "Karma",
                "Transformation",
                "Strength"
            ),
            natureTypes = listOf(
                "Fire"
            )
        ),
        AnimeHero(
            id = 11,
            name = "Orochimaru",
            image = "/images/orochimaru.jpg",
            about = "Orochimaru (大蛇丸, Orochimaru) is one of Konohagakure's legendary Sannin. With a life-ambition to learn all of the world's secrets, Orochimaru seeks immortality so that he might live all of the lives necessary to accomplish his task. After being caught red-handed performing unethical experiments on his fellow citizens for the sake of this immortality, Orochimaru defected from Konoha.",
            rating = 4.5,
            power = 97,
            month = "Oct",
            day = "27th",
            family = listOf(
                "Mitsuki",
                "Log"
            ),
            abilities = listOf(
                "Senin Mode",
                "Transformation",
                "Science"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire",
                "Earth",
                "Water"
            )
        ),
        AnimeHero(
            id = 12,
            name = "Kakashi",
            image = "/images/kakashi.png",
            about = "Kakashi Hatake (はたけカカシ, Hatake Kakashi) is a shinobi of Konohagakure's Hatake clan. Famed as Kakashi of the Sharingan (写輪眼のカカシ, Sharingan no Kakashi), he is one of Konoha's most talented ninja, regularly looked to for advice and leadership despite his personal dislike of responsibility. To his students on Team 7, Kakashi emphasises the importance of teamwork; he himself received this lesson, along with the Sharingan, from his childhood friend, Obito Uchiha.",
            rating = 4.5,
            power = 96,
            month = "Sep",
            day = "15th",
            family = listOf(
                "Sakumo"
            ),
            abilities = listOf(
                "Intelligence",
                "Strength"
            ),
            natureTypes = listOf(
                "Lightning",
                "Wind",
                "Fire",
                "Earth",
                "Water"
            )
        )
    )
    val page5 = listOf(
        AnimeHero(
            id = 13,
            name = "Isshiki",
            image = "/images/ishiki.jpg",
            about = "A thousand years ago, Isshiki came to Earth alongside Kaguya with the objective to plant a Tree to harvest its Chakra Fruit. While Kaguya, being lower-ranked, was planned to be sacrificed to create the Chakra Fruit, she instead turned on Isshiki, leaving him on the verge of death after destroying Isshiki's lower half. Encountering Jigen and not having the strength to implant a Kāma on him, Isshiki devised a desperate plan and shrunk himself to enter the monk's ear in order to survive his injury by absorbing Jigen's nutrients.",
            rating = 5.0,
            power = 100,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Otsutsuki Clan"
            ),
            abilities = listOf(
                "Sukunahikona",
                "Daikokuten",
                "Byakugan",
                "Space–Time",
                "Intelligence"
            ),
            natureTypes = listOf(
                "Fire"
            )
        ),
        AnimeHero(
            id = 14,
            name = "Momoshiki",
            image = "/images/momoshiki.jpg",
            about = "Momoshiki Ōtsutsuki (大筒木モモシキ, Ōtsutsuki Momoshiki) was a member of the Ōtsutsuki clan's main family, sent to investigate the whereabouts of Kaguya and her God Tree and then attempting to cultivate a new one out of the chakra of the Seventh Hokage. In the process of being killed by Boruto Uzumaki, Momoshiki placed a Kāma on him, allowing his spirit to remain intact through the mark.",
            rating = 3.9,
            power = 98,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Otsutsuki Clan"
            ),
            abilities = listOf(
                "Rinnegan",
                "Byakugan",
                "Strength"
            ),
            natureTypes = listOf(
                "Fire",
                "Lightning",
                "Wind",
                "Water",
                "Earth"
            )
        ),
        AnimeHero(
            id = 15,
            name = "Urashiki",
            image = "/images/urashiki.jpg",
            about = "Urashiki Ōtsutsuki (大筒木ウラシキ, Ōtsutsuki Urashiki) was a low-ranking member of the Ōtsutsuki clan's main family, sent to assist Momoshiki and Kinshiki on their mission to investigate Kaguya's whereabouts and gather the chakra of the God Tree on Earth. Compared to his comrades, Urashiki had been shown to have a rather laid-back and jovial personality. He was quite willing to joke along with Momoshiki and Kinshiki, and disparaged on how serious they are.",
            rating = 3.4,
            power = 95,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Otsutsuki Clan"
            ),
            abilities = listOf(
                "Space–Time",
                "Rinnegan",
                "Byakugan"
            ),
            natureTypes = listOf(
                "Fire",
                "Lightning",
                "Wind",
                "Earth"
            )
        )
    )
    val page6 = listOf(
        AnimeHero(
            id = 16,
            name = "Code",
            image = "/images/code.jpg",
            about = "Code (コード, Kōdo) is the last active Inner from Kara. Carrying Isshiki Ōtsutsuki's legacy within him, he inherits the Ōtsutsuki Clan's will to become a Celestial Being and continually evolve. At the time Kawaki was brought to Kara, Code was one of fifteen candidates in Jigen and Amado's Ōtsutsuki ritual to screen for a Kāma vessel for Isshiki. Only Kawaki survived to become an actual vessel.",
            rating = 4.8,
            power = 99,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Unknown"
            ),
            abilities = listOf(
                "White Karma",
                "Transformation",
                "Genjutsu"
            ),
            natureTypes = listOf(
                "Unknown"
            )
        ),
        AnimeHero(
            id = 17,
            name = "Amado",
            image = "/images/amado.jpg",
            about = "Amado (アマド, Amado) is a former Inner from the organisation Kara and the head of its research and development division. He has since defected to Konohagakure, where he used a mix of bluffs and gifts to gain official citizenship for the Hokage's protection. Amado had a daughter who died twelve years prior to the reign of the Seventh Hokage. In his quest to kill Isshiki Ōtsutsuki, Amado joined Kara and was granted the rank of Inner, serving as the head of its research and development division.",
            rating = 5.0,
            power = 90,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Unknown"
            ),
            abilities = listOf(
                "Science",
                "Intelligence",
                "Trickery"
            ),
            natureTypes = listOf(
                "Unknown"
            )
        ),
        AnimeHero(
            id = 18,
            name = "Koji",
            image = "/images/koji.jpg",
            about = "Koji Kashin (果心居士, Kashin Koji) is a clone of Jiraiya that was created by Amado for the purpose of killing Isshiki Ōtsutsuki. A former Inner of Kara, he was in charge of the sector on the outskirts of the Land of Fire. An enigmatic man, Koji has a very stoic and straightforward nature that follows a no-nonsense view. Arrogant as he may appear, he has consistently shown himself to be a very rational and perceptive man.",
            rating = 4.5,
            power = 90,
            month = "Jan",
            day = "1st",
            family = listOf(
                "Jiraiya"
            ),
            abilities = listOf(
                "Senin Mode",
                "Rasengan",
                "Shadow Clone"
            ),
            natureTypes = listOf(
                "Fire",
                "Earth"
            )
        )
    )


    fun clearData() {
        page1 = emptyList()
    }

    private var exception = false

    fun addException() {
        exception = true
    }

    private fun calculate(page: Int): Map<String, Int?> {
        if (page1.isEmpty()) {
            return mapOf("previousPage" to null, "nextPage" to null)
        }
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 5) {
            nextPage = null
        }
        return mapOf("previousPage" to prevPage, "nextPage" to nextPage)
    }

    override suspend fun getAllAnimeHeroes(page: Int): AnimeApiResponse {
        if (exception) {
            throw IOException()
        }
        require(page in 1..5)
        return AnimeApiResponse(
            success = true,
            message = "ok",
            previousPage = calculate(page = page)["prevPage"],
            nextPage = calculate(page = page)["nextPage"],
            animeHeroes = animeHeroes[page]!!
        )
    }

    override suspend fun searchAnimeHeroes(name: String): AnimeApiResponse {
        return AnimeApiResponse(
            success = false
        )
    }
}