package com.example.project001.navigation.routes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.project001.core.model.doctorModel

fun NavGraphBuilder.detailScreen(
    nav: NavHostController,
    onBack: () -> Unit
){
composable(Screen.Detail.route){
    backStackEntry: NavBackStackEntry ->
   val context = LocalContext.current
    val prevEntry = remember(key1 = nav){nav.previousBackStackEntry}
    val doctor = remember(key1 = prevEntry){
        prevEntry?.savedStateHandle?.get<doctorModel>("doctor")
    }
    LaunchedEffect(key1 = prevEntry, key2 = doctor){
        if (doctor == null){
            onBack()
        }
        else{
            prevEntry?.savedStateHandle?.remove<doctorModel>(key = "doctor")
        }
    }
    if (doctor != null){

    }
    else{
        Spacer(modifier = Modifier.height(1.dp))
    }
}
}