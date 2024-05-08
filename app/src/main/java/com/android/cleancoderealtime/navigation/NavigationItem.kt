package com.android.cleancoderealtime.navigation

sealed class NavigationItem(val route: String) {
    data object WELCOME : NavigationItem(Screen.WELCOME.name)
    data object LOGIN : NavigationItem(Screen.LOGIN.name)
}
