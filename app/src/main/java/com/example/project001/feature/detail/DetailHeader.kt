package com.example.project001.feature.detail

import android.graphics.Color
import android.graphics.Picture
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.project001.R

@Composable
fun DetailHeader(
    picture: String?,
    onBack: () -> Unit,
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(color = colorResource(R.color.purple))
            .statusBarsPadding()
    ){
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .align (Alignment.TopStart)
                .padding(start = 16.dp , top = 8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.back_white),
                contentDescription = null,
                tint = androidx.compose.ui.graphics.Color.Unspecified

            )
        }
        IconButton(
            onClick = {},
            modifier = Modifier
                .align (Alignment.TopEnd)
                .padding(end = 16.dp , top = 8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.favorite_white),
                contentDescription = null,
                tint = androidx.compose.ui.graphics.Color.Unspecified
            )
        }
        AsyncImage(
            model = picture,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize().align(Alignment.TopCenter)

        )
    }
}

@Preview
@Composable
fun DetailHeaderPreview(){
    Box {
        DetailHeader(picture = "https://rickandmortyapi.com/api/character/avatar/1.jpeg", onBack = {})
    }

}