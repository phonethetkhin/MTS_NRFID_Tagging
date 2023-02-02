package com.ptk.mts_nrfid_tagging.ui.ui_resource.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ptk.mts_nrfid_tagging.ui.screen.HomeScreen
import com.ptk.mts_nrfid_tagging.ui.ui_resource.navigation.Routes


@Composable
fun NavGraph(

    navController: NavHostController,

    ) {
    NavHost(navController = navController, startDestination = Routes.HomeScreen.route) {

        composable(route = Routes.HomeScreen.route) {
            HomeScreen(navController)
        }
    }
}