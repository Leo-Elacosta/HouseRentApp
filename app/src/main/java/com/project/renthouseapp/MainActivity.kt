package com.project.renthouseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.project.renthouseapp.ui.screens.AppNavigation
import com.project.renthouseapp.ui.theme.RentHouseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentHouseAppTheme {
                AppNavigation()
            }
        }
    }
}
