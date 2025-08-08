package com.henckel.sorteiatimes.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.henckel.sorteiatimes.presentation.screens.home.HomeScreen
import com.henckel.sorteiatimes.presentation.screens.result.ResultScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        startDestination = AppScreens.HomeScreen.name
    ) {

        composable(route = AppScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }

        composable(route = AppScreens.SortResultScreen.name) {
            ResultScreen(navController = navController)
        }
        
    }
}

enum class AppScreens {
    HomeScreen,
    SortResultScreen,
}