---
id: 7og4ondc
title: AnimeHeroDao
file_version: 1.1.3
app_version: 1.12.0
---

This code snippet defines an interface `AnimeHeroDao` that contains several database queries and operations related to the `anime_hero_table` table. It provides methods to retrieve all anime heroes in a paginated manner, retrieve a specific anime hero by their ID, insert a list of anime heroes, and delete all anime heroes from the table.
<!-- NOTE-swimm-snippet: the lines below link your snippet to Swimm -->
### 📄 app/src/main/java/com/tariq/animeheroes/data/local/dao/AnimeHeroDao.kt
```kotlin
11     @Dao
12     interface AnimeHeroDao {
13     
14         @Query("SELECT * FROM anime_hero_table ORDER BY id ASC")
15         fun getAllAnimeHeroes(): PagingSource<Int, AnimeHero>
16     
17         @Query("SELECT * FROM anime_hero_table WHERE id=:animeHeroId")
18         fun getSelectedAnimeHero(animeHeroId: Int): AnimeHero
19     
20         @Insert(onConflict = OnConflictStrategy.REPLACE)
21         suspend fun addAllAnimeHeroes(animeHeroes: List<AnimeHero>)
22     
23         @Query("DELETE FROM anime_hero_table")
24         suspend fun deleteAllAnimeHeroes()
25     
26     }
```

<br/>

This file was generated by Swimm. [Click here to view it in the app](https://app.swimm.io/repos/Z2l0aHViJTNBJTNBQW5pbWVIZXJvQXBwJTNBJTNBVGFyaXEyNTE4/docs/7og4ondc).
