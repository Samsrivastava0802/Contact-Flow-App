package com.samridhi.contactflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.samridhi.contactflow.navigation.AppNavGraph
import com.samridhi.contactflow.navigation.AppNavigationActions
import com.samridhi.contactflow.presentation.ExampleScreen
import com.samridhi.contactflow.ui.theme.ContactFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactFlowTheme {
               ContactApp(
                   onNavigationEnd = {
                      finish()
                   }
               )
            }
        }
    }
}

@Composable
fun ContactApp(
    onNavigationEnd: () -> Unit,
) {
    val navController = rememberNavController()
    val navActions: AppNavigationActions = remember(navController) {
        AppNavigationActions()
    }
    AppNavGraph(
        navController = navController,
        navActions = navActions
    )
}

