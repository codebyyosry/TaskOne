package com.yosry.dev.taskone.ui.navigation

sealed class Screen(route: String) {
    object HomeScreen : Screen("home_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object ProfileScreen : Screen("profile_screen")
    object SplashScreen : Screen("splash_screen")
}