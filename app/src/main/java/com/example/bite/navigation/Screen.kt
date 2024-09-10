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
    data object OrderHistory : Screen("OrderHistory")
    data object OrderDetails : Screen("OrderDetails")
    data object RestaurantMenu : Screen("RestaurantMenu")
    data object BusinessRegistration : Screen("BusinessRegistration")


    // Agrega nuevas pantallas aquí
}
