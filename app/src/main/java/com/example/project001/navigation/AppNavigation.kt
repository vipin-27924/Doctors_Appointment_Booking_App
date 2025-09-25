package com.example.project001.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.project001.core.ViewModel.MainViewModel
import com.example.project001.navigation.routes.Screen
import com.example.project001.navigation.routes.homeRoute
import com.example.project001.navigation.routes.introRoute

@Composable
fun AppNavGraph(
    nav: NavHostController,
    vm: MainViewModel
){
    NavHost(navController = nav, startDestination = Screen.Intro.route){
        introRoute(
            onStart = {
                nav.navigate(Screen.Home.route){
                    popUpTo(Screen.Intro.route)
                    {inclusive = true}
                }
            }
        )
        homeRoute(vm = vm, onOpenTopDoctors = {/* */})
    }
}