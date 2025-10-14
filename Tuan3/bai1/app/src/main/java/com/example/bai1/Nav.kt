package com.example.bai1

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

object Routes {
    const val Welcome = "welcome"
    const val List = "list"
    const val Text = "text"
    const val Image = "image"
    const val TextField = "textfield"
    const val PasswordField = "passwordfield"   // ⬅️ mới
    const val RowLayout = "rowlayout"
    const val ColumnLayout = "columnlayout"     // ⬅️ mới
}

@Composable
fun AppNavHost(nav: NavHostController) {
    NavHost(navController = nav, startDestination = Routes.Welcome) {
        composable(Routes.Welcome) { WelcomeScreen(onReady = { nav.navigate(Routes.List) }) }
        composable(Routes.List) { ComponentsListScreen(nav) }
        composable(Routes.Text) { TextDetailScreen(nav) }
        composable(Routes.Image) { ImagesScreen(nav) }
        composable(Routes.TextField) { TextFieldScreen(nav) }
        composable(Routes.PasswordField) { PasswordFieldScreen(nav) }   // ⬅️
        composable(Routes.RowLayout) { RowLayoutScreen(nav) }
        composable(Routes.ColumnLayout) { ColumnLayoutScreen(nav) }     // ⬅️
    }
}

