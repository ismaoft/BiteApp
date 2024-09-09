package com.example.bite.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object Home : Screen("home")
    data object AdminHome  : Screen("adminHome")
    data object Register1 : Screen("register1")
    data object Register2 : Screen("register2")
    data object Register3 : Screen("register3")
    data object Loading : Screen("loading")
    data object SearchPage : Screen("SerachPage")

    // Agrega nuevas pantallas aquí
}
