package com.example.assigmenttodo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


object NavGraph{
    const val ROOT = "root"
    const val SPLASH = "splash"
    const val HOME = "home"
}

@Composable
fun RootNavGraph(navController : NavHostController){

    NavHost(navController = navController,
        route = NavGraph.ROOT,
        startDestination = NavGraph.SPLASH
    ){
        splashNavGraph(navController)
        homeNavGraph(navController =  navController)
    }
}