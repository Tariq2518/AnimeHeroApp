---
id: lml0s9yl
title: MainActivity
file_version: 1.1.3
app_version: 1.12.0
---

This code is for the main activity of an Android application. It sets the content of the activity to a specific theme and initializes a navigation controller. It also sets up the navigation graph for the application.
<!-- NOTE-swimm-snippet: the lines below link your snippet to Swimm -->
### 📄 app/src/main/java/com/tariq/animeheroes/MainActivity.kt
```kotlin
22     class MainActivity : ComponentActivity() {
23         lateinit var navController: NavHostController
24         override fun onCreate(savedInstanceState: Bundle?) {
25             super.onCreate(savedInstanceState)
26             setContent {
27                 AnimeHeroesTheme {
28                     navController = rememberNavController()
29                     SetupNavGraph(navController = navController)
30                 }
31             }
32         }
33     }
```

<br/>

This file was generated by Swimm. [Click here to view it in the app](https://app.swimm.io/repos/Z2l0aHViJTNBJTNBQW5pbWVIZXJvQXBwJTNBJTNBVGFyaXEyNTE4/docs/lml0s9yl).
