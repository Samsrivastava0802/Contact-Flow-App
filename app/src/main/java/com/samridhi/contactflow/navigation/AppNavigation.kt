package com.samridhi.contactflow.navigation

sealed class AppScreen(val name: String, val route: String) {
    data object HomeScreen : AppScreen("home", "home")
    data object AddOrEditScreen : AppScreen("addOrEdit", "addOrEdit")
    data object SyncContactScreen : AppScreen("syncContact", "syncContact")

}