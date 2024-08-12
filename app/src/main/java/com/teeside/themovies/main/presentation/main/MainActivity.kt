package com.teeside.themovies.main.presentation.main


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.teeside.themovies.biometric.presentation.BiometricUIScreen
import com.teeside.themovies.media_details.presentation.details.MediaDetailsScreenEvents
import com.teeside.themovies.media_details.presentation.details.MediaDetailsViewModel
import com.teeside.themovies.media_details.presentation.details.MediaDetailScreen
import com.teeside.themovies.media_details.presentation.details.SomethingWentWrong
import com.teeside.themovies.media_details.presentation.similar_media.SimilarMediaListScreen
import com.teeside.themovies.media_details.presentation.watch_video.WatchVideoScreen
import com.teeside.themovies.search.presentation.SearchScreen
import com.teeside.themovies.theme.TheMoviesTheme
import com.teeside.themovies.util.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheMoviesTheme {

                val mainViewModel = hiltViewModel<MainViewModel>()
                val mainUiState = mainViewModel.mainUiState.collectAsState().value

                installSplashScreen().apply {
                    setKeepOnScreenCondition {
                        mainViewModel.showSplashScreen.value
                    }
                }

                BiometricUIScreen()



            }
        }

    }
}

@Composable
fun Navigation(
    mainUiState: MainUiState,
    onEvent: (MainUiEvents) -> Unit
) {
    val navController = rememberNavController()

    val mediaDetailsViewModel = hiltViewModel<MediaDetailsViewModel>()
    val mediaDetailsScreenState =
        mediaDetailsViewModel.mediaDetailsScreenState.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Route.MEDIA_MAIN_SCREEN
    ) {

        composable(Route.MEDIA_MAIN_SCREEN) {
            MediaMainScreen(
                navController = navController,
                mainUiState = mainUiState,
                onEvent = onEvent
            )
        }

        composable(Route.SEARCH_SCREEN) {
            SearchScreen(
                navController = navController,
                mainUiState = mainUiState,
            )
        }

        composable(
            "${Route.MEDIA_DETAILS_SCREEN}?id={id}&type={type}&category={category}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("type") { type = NavType.StringType },
                navArgument("category") { type = NavType.StringType }
            )
        ) {

            val id = it.arguments?.getInt("id") ?: 0
            val type = it.arguments?.getString("type") ?: ""
            val category = it.arguments?.getString("category") ?: ""

            LaunchedEffect(key1 = true) {
                mediaDetailsViewModel.onEvent(
                    MediaDetailsScreenEvents.SetDataAndLoad(
                        moviesGenresList = mainUiState.moviesGenresList,
                        tvGenresList = mainUiState.tvGenresList,
                        id = id,
                        type = type,
                        category = category
                    )
                )
            }

            if (mediaDetailsScreenState.media != null) {
                MediaDetailScreen(
                    navController = navController,
                    media = mediaDetailsScreenState.media,
                    mediaDetailsScreenState = mediaDetailsScreenState,
                    onEvent = mediaDetailsViewModel::onEvent
                )
            } else {
                SomethingWentWrong()
            }
        }

        composable(
            "${Route.SIMILAR_MEDIA_LIST_SCREEN}?title={title}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
            )
        ) {

            val name = it.arguments?.getString("title") ?: ""

            SimilarMediaListScreen(
                navController = navController,
                mediaDetailsScreenState = mediaDetailsScreenState,
                name = name,
            )
        }

        composable(
            "${Route.WATCH_VIDEO_SCREEN}?videoId={videoId}",
            arguments = listOf(
                navArgument("videoId") { type = NavType.StringType }
            )
        ) {

            val videoId = it.arguments?.getString("videoId") ?: ""

            WatchVideoScreen(
                lifecycleOwner = LocalLifecycleOwner.current,
                videoId = videoId
            )
        }
    }
}













