package com.example.assigmenttodo.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.assigmenttodo.presentation.ui.screens.HomeScreen


fun NavGraphBuilder.homeNavGraph(navController: NavController){
    navigation(
        route = NavGraph.HOME,
        startDestination = HomeScreens.HomeScreen.route
    ) {
        composable(route = HomeScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
    }
        }

sealed class HomeScreens(val route : String){
    data object HomeScreen : HomeScreens(route = "home_screen")
}
