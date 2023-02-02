package com.ptk.mts_nrfid_tagging

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.ptk.mts_nrfid_tagging.ui.ui_resource.theme.MTS_NRFID_TaggingTheme
import com.ptk.mts_nrfid_tagging.ui.ui_resource.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MTS_NRFID_TaggingTheme {
                MainComposable()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainComposable() {
    val navController = rememberNavController()

    Scaffold(
    ) {
        NavGraph(
            navController = navController,
        )
    }
}
