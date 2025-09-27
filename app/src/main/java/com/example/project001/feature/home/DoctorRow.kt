package com.example.project001.feature.home

import android.R.attr.onClick
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.project001.R
import com.example.project001.core.model.doctorModel

@Composable
fun DoctorCard(item: doctorModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(width = 190.dp, height = 260.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.white)),
        onClick = { /*TODO*/ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(165.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = colorResource(R.color.lightPurple))
            ) {
                AsyncImage(
                    model = item.Picture,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Fit,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.Name ?: " ",
                color = colorResource(R.color.black),
                modifier = Modifier,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))

            Text(
                text = item.Special ?: " ",
                color = colorResource(R.color.gray),
                modifier = Modifier,
                fontSize = 12.sp,
                fontWeight = FontWeight.W500
            )
            Spacer(Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null
                )
                Spacer(Modifier.width(4.dp))

                Text(
                    text = item.Rating?.toString() ?: "",
                    color = colorResource(R.color.black),
                    modifier = Modifier,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.width(70.dp))

                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.experience),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = item.Expriense?.toString() ?: "",
                    color = colorResource(R.color.black),
                )
            }
        }
    }
}

@Preview
@Composable
fun DoctorRowPreview(){
    val item = doctorModel( Name = "Vipin kumar" , Picture =  "picture_url" , Special = "Cardiology", Rating = 4.5, Expriense = 10)
    DoctorCard(item = item, onClick = {})
}

@Composable
fun DoctorRow(
    items : List<doctorModel>,
    onClick: () -> Unit){
    Box(
    ){
        if (items.isEmpty()){
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center),
                color = colorResource(R.color.lightPurple),
                strokeWidth = 2.dp
            )
        }
        else{
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
            ){
                items(items){item ->
                    DoctorCard(item = item, onClick = onClick)
                }
            }
        }

    }


}