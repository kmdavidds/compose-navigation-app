package com.example.composenavigationapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            _root_ide_package_.android.window.SplashScreen(
                onFinished = {
                    navController.navigate(Routes.MAIN_GRAPH) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        navigation(
            startDestination = Routes.HOME,
            route = Routes.MAIN_GRAPH
        ) {
            composable(Routes.HOME) { PlaceholderHomeScreen() }
        }
    }
}
