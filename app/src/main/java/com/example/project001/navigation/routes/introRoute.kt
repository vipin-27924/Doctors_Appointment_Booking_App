package com.example.project001.navigation.routes

import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.project001.feature.intro.introScreen

fun NavGraphBuilder.introRoute(onStart : () -> Unit){
    composable(route = Screen.Intro.route){
        introScreen (onStartClick = onStart)
    }
}