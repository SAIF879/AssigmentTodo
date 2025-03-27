package com.example.assigmenttodo.presentation.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.assigmenttodo.presentation.ui.screens.home.HomeScreen
import com.example.assigmenttodo.presentation.ui.screens.home.HomeViewmodel


fun NavGraphBuilder.homeNavGraph(){
    navigation(
        route = NavGraph.HOME,
        startDestination = HomeScreens.HomeScreen.route
    ) {
        composable(route = HomeScreens.HomeScreen.route) {
            val  viewmodel : HomeViewmodel = hiltViewModel()
            val blogList by viewmodel.tasks.collectAsState()
            HomeScreen(blogList)
        }
    }
        }

sealed class HomeScreens(val route : String){
    data object HomeScreen : HomeScreens(route = "home_screen")
}
