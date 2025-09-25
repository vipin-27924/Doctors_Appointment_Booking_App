package com.example.project001.feature.home

import com.example.project001.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionHeader(
    title: String,
    onSeeAll:(()-> Unit)
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp , top = 24.dp , end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
        )
        if(onSeeAll != null){
            TextButton(onClick = onSeeAll) {
                Text(text = "See All",
                    color = colorResource(id = R.color.darkPurple))
            }
        }else{
            Text(
                text = "See All",
                color = colorResource(R.color.darkPurple)
            )
        }
    }
}
