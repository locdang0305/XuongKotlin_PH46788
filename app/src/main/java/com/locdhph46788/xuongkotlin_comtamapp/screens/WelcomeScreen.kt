package com.locdhph46788.xuongkotlin_comtamapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.locdhph46788.xuongkotlin_comtamapp.R
import com.locdhph46788.xuongkotlin_comtamapp.navigations.ROUTE_MAIN_NAV
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(2000L)
        navController.navigate(ROUTE_MAIN_NAV.LOGIN.name) {
            popUpTo(ROUTE_MAIN_NAV.WELCOME.name) { inclusive = true }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff252121)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxSize()
        )
    }
}