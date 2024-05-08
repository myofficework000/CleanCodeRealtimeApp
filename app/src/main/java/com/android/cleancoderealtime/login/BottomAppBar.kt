package com.android.cleancoderealtime.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.cleancoderealtime.R
import com.android.cleancoderealtime.navigation.NavigationItem

@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding -> Modifier.padding(2.dp)

    }
}

    @Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        contentColor = Color.Black
    ) {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_home_24), contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_loop_24), contentDescription = "Infinite") },
            label = { Text("Infinite") },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_email_24), contentDescription = "Mail") },
            label = { Text("Email") },
            selected = false,
            onClick = {}
        )

        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_search_24), contentDescription = "Search") },
            label = { Text("Search") },
            selected = false,
            onClick = { navController.navigate(NavigationItem.LOGIN.route)}
        )
    }
}

@Preview
@Composable
private fun WelcomeScreenPrev() {
    WelcomeScreen(rememberNavController())

}