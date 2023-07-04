---
id: 7fejmib8
title: AnimeHeroDatabase
file_version: 1.1.3
app_version: 1.12.0
---

This code defines a `AnimeHeroDatabase` class that extends `RoomDatabase`. It is responsible for creating and managing the database for storing `AnimeHero` and `AnimeHeroRemoteKey` entities. It also provides access to the DAOs (`animeHeroDao()` and `heroRemoteKeyDao()`) for querying and manipulating the data in the database. Additionally, it specifies a type converter (`DatabaseConverter::class`) to handle converting custom types for database storage.
<!-- NOTE-swimm-snippet: the lines below link your snippet to Swimm -->
### 📄 app/src/main/java/com/tariq/animeheroes/data/local/AnimeHeroDatabase.kt
```kotlin
11     @Database(entities = [AnimeHero::class, AnimeHeroRemoteKey::class], version = 1)
12     @TypeConverters(DatabaseConverter::class)
13     abstract class AnimeHeroDatabase: RoomDatabase() {
14     
15         abstract fun animeHeroDao(): AnimeHeroDao
16     
17         abstract fun heroRemoteKeyDao(): AnimeHeroRemoteKeyDao
18     
19     }
```

<br/>

This file was generated by Swimm. [Click here to view it in the app](https://app.swimm.io/repos/Z2l0aHViJTNBJTNBQW5pbWVIZXJvQXBwJTNBJTNBVGFyaXEyNTE4/docs/7fejmib8).