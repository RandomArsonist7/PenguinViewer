package com.example.app1jetpackcompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.app1jetpackcompose.ui.theme.App1JetpackComposeTheme
import com.example.app1jetpackcompose.ui.theme.App1JetpackComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            App1JetpackComposeTheme {
                AppNavigation()
            }
        }
    }
}





@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val cardItems = remember {
        mutableStateListOf(
            CardItem(
                "Pingwin Cesarski",
                1,
                R.drawable.emperor,
                "600tys",
                "Antarktyda",
                context.getString(R.string.Emperor),
                likes = 0,
                "Aptenodytes forsteri",
                "22-45kg",
                "1,1-1,3m"
            ),
            CardItem(
                "Pingwin Królewski",
                2,
                R.drawable.king,
                "2,23mln",
                "Wschodnia Antarktyda, wyspy subantarktyczne",
                context.getString(R.string.King),
                likes = 0,
                "Aptenodytes patagonicus",
                "11-16kg",
                "85-95cm"
            ),
            CardItem(
                "Pingwin Adeli",
                3,
                R.drawable.adelie,
                "3,8mln",
                "Wybrzeża Antarktydy, głównie wzdłuż wschodnich i zachodnich części kontynentu",
                context.getString(R.string.Adelie),
                likes = 0,
                "Pygoscelis adeliae",
                "3,5-6kg",
                "70-75cm"
            ),
            CardItem(
                "Pingwin Magellański",
                4,
                R.drawable.magellanic,
                "1,5mln",
                "Wybrzeża południowej Ameryki Południowej, w tym Argentyna, Chile oraz Falklandy",
                context.getString(R.string.Magellanic),
                likes = 0,
                "Spheniscus magellanicus",
                "4-6kg",
                "70-76cm"
            ),
            CardItem(
                "Pingwin Humboldta",
                5,
                R.drawable.humboldt,
                "30-50tys",
                "Wybrzeża Peru i Chile, wzdłuż wybrzeży Pacyfiku",
                context.getString(R.string.Humboldt),
                likes = 0,
                "Spheniscus humboldti",
                "2,5-4,5kg",
                "60-70cm"
            ),
            CardItem(
                "Pingwin Niebieski",
                6,
                R.drawable.blue,
                "1,5mln",
                "Wybrzeża Nowej Zelandii oraz południowa część Australii",
                context.getString(R.string.Blue),
                likes = 0,
                "Eudyptula minor",
                "1-1,5kg",
                "33=35cm"
            ),
            CardItem(
                "Pingwin Białobrewy",
                7,
                R.drawable.gentoo,
                "1,2mln",
                "Wyspy subantarktyczne, w tym Falklandy, Georgia Południowa oraz wyspy Kerguelena",
                context.getString(R.string.White),
                likes = 0,
                "Pygoscelis papua",
                "5-8kg",
                "70-76cm"
            ),
            CardItem(
                "Pingwin Wyspiarski",
                8,
                R.drawable.island,
                "2-3mln",
                "Wyspy subantarktyczne, w tym Falklandy, Wyspy Kerguelena, Georgia Południowa oraz wybrzeża Antarktydy",
                context.getString(R.string.Island),
                likes = 0,
                "Eudyptes chrysocome",
                "2-5kg",
                "55-70cm"
            ),
            CardItem(
                "Pingwin Maskowy",
                9,
                R.drawable.mask,
                "3mln",
                "Wybrzeża Galapagos (Ekwador)",
                context.getString(R.string.Mask),
                likes = 0,
                "Pygoscelis antarcticus",
                "5,5kg",
                "75cm"
            ),
            CardItem(
                "Pingwin Przylądkowy",
                10,
                R.drawable.african,
                "50-60tys",
                "Wybrzeża Południowej Afryki oraz Wyspa Marion",
                context.getString(R.string.African),
                likes = 0,
                "Spheniscus demersus",
                "2,2-4kg",
                "60-70cm"
            )
        )
    }



    NavHost(navController = navController, startDestination = "home"){
            composable("home") {
                HomeScreen(navController = navController, cardItems = cardItems)
            }
            composable("detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                // Szukamy karty po id i przekazujemy wszystkie dane
                val card = cardItems.find { it.id == id }
                if (card != null) {
                    DetailScreen(
                        card = card,
                        onLikeClick = { cardId ->
                            val updatedCard = cardItems.find { it.id == cardId }
                            updatedCard?.likes = updatedCard?.likes?.plus(1) ?: 0
                        }
                    )
                }
            }
        }
    }

@Composable
fun HomeScreen(navController: NavController, cardItems:List<CardItem>) {
    MainUI(
        items = cardItems,
        onCardClick = { id ->
            navController.navigate("detail/$id")
        }
    )
}


@Composable
fun GreetingPreview() {
    HomeScreen(navController = rememberNavController(), cardItems = listOf(
        CardItem("Karta 1", 1, R.drawable.emperor, "200", "Australia", "Funny cute perfect", 0, "Ping", "5lbs", "tall.")
    ))
}

