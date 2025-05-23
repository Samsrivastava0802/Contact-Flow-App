package com.samridhi.contactflow.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.samridhi.contactflow.presentation.homescreen.HomeScreen


@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = AppScreen.HomeScreen.route,
    navActions: AppNavigationActions
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ){
        composable(
            route = AppScreen.HomeScreen.route
        ) {
            HomeScreen()
        }

        composable(
            route = AppScreen.AddOrEditScreen.route
        ) {

        }
        composable(
            route = AppScreen.SyncContactScreen.route
        ) {

        }
    }

}