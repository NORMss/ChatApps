package com.norm.mychatapps.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: Screen = Screen.Auth,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Screen.Auth> { }
        composable<Screen.Home> { }
        composable<Screen.Chat> { }
        composable<Screen.ChatRoom> { }
    }
}