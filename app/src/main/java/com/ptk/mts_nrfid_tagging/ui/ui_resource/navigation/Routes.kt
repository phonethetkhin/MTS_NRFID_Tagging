package com.ptk.mts_nrfid_tagging.ui.ui_resource.navigation

sealed class Routes(val route: String) {
    object HomeScreen : Routes("/home_screen")
}