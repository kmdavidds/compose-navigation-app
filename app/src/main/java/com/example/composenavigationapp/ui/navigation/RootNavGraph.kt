package com.example.composenavigationapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composenavigationapp.ui.screens.PlaceholderHomeScreen
import com.example.composenavigationapp.ui.screens.SplashScreen

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onFinished = {
                    navController.navigate(Routes.MAIN_GRAPH){
                        popUpTo(Routes.SPLASH){ inclusive = true}
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
