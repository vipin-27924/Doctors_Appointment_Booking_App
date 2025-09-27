package com.example.project001.feature.home

import android.graphics.Picture
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontLoadingStrategy.Companion.Async
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.Navigator
import coil.compose.AsyncImage
import com.example.project001.R
import com.example.project001.core.model.CategoryModel
import java.util.jar.Attributes

@Composable
fun CategoryRow(item: CategoryModel) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(colorResource(R.color.lightPurple)),
            contentAlignment = Alignment.Center
        ){
            AsyncImage(
                model = item.Picture,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.Name?: "",
            color = colorResource(id = R.color.darkPurple )
            )
    }
}


@Preview
@Composable
fun CategoryRowPreview(){
    val item = CategoryModel(id = 1 , Name = "Category 1" , Picture = "picture_url")
    CategoryRow(item = item)
}

@Composable
fun CategoryRow(items : List<CategoryModel>){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 100.dp)
    ){
        if(items.isEmpty()){
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        else{
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier
                    .padding(top = 16.dp)
            ){
                items(items){item ->
                    CategoryRow(item = item)
                }
            }

        }

    }
}