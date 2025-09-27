package com.example.project001.navigation.routes

import android.R.attr.category
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.project001.core.ViewModel.MainViewModel
import com.example.project001.feature.home.MainScreen

fun NavGraphBuilder.homeRoute(
    vm : MainViewModel,
    onOpenTopDoctors :() -> Unit,
){
    composable(route = Screen.Home.route) {
        val categories = vm.Category.observeAsState(emptyList())
        LaunchedEffect(Unit) {
            if (categories.value.isEmpty()) {
                vm.loadCategories()
                vm.loadDoctors()
            }
        }
        MainScreen(viewModel = vm)
    }

}