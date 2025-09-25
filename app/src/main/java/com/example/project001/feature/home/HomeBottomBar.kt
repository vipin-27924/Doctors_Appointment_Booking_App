package com.example.project001.feature.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project001.R

@Composable
fun HomeBottomBar(selected: Int, onSelect: (Int) -> Unit) {
    NavigationBar(
        contentColor = colorResource(R.color.lightGray),
        tonalElevation = 10.dp,
        modifier = Modifier
            .height(60.dp),
        windowInsets = WindowInsets(0)
    ) {
        val titles = listOf("Explorer", "WishList", "Settings", "Account")
        val icons = listOf( // Renamed to follow Kotlin conventions (lowercase)
            R.drawable.btn_1,
            R.drawable.btn_2,
            R.drawable.btn_3,
            R.drawable.btn_4
        )

        titles.forEachIndexed { index, title ->
            NavigationBarItem(
                selected = selected == index,
                // FIX 1: Pass the onClick as a lambda function.
                onClick = { onSelect(index) },
                icon = {
                    Icon(
                        painter = painterResource(id = icons[index]),
                        contentDescription = title, // It's good practice to add a content description
                        modifier = Modifier.size(22.dp),
                        tint = Color.Unspecified
                    )
                },
                label = {
                    Text(
                        // FIX 2: Use the 'title' from the loop, not the whole 'titles' list.
                        text = title,
                        fontSize = 10.sp,
                        color = Color.Black
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}

@Preview
@Composable
fun HomeBottomPreview() {
    HomeBottomBar(selected = 0, onSelect = {})
}