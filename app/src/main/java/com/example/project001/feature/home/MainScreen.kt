package com.example.project001.feature.home
import android.R.attr.category
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project001.core.ViewModel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    val doctors by viewModel.doctors.observeAsState(emptyList())
    val categories by viewModel.Category.observeAsState(emptyList())
    var selectedBottom by remember { mutableStateOf(0) }
    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            HomeBottomBar(
                selected = selectedBottom,
                onSelect = { selectedBottom = it }
            )
        }
    ) { inner ->
        LazyColumn(contentPadding = inner) {
            item { HomeHeader() }
            item { Banner() }
            item { SectionHeader(title = "Doctor Speciality", onSeeAll = { /* */ }) }
            item { CategoryRow(items = categories) }
            item { SectionHeader(title = "Doctors", onSeeAll = { /* */ }) }
            item { DoctorRow(items = doctors, onClick = { /*TODO*/ }) }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    val viewModel : MainViewModel = viewModel()
    MainScreen(viewModel = viewModel)
}