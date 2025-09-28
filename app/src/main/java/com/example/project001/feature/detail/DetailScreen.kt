package com.example.project001.feature.detail

import android.provider.ContactsContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project001.R
import com.example.project001.core.model.doctorModel
import kotlin.coroutines.coroutineContext

@Composable
fun DetailScreen(
    item: doctorModel,
    onBack: () -> Unit,
    onOpenWebsite: (String)-> Unit,
    onSendSms: (String) -> Unit,
    onDial:(mobile: String) -> Unit,
    onDirection:(location: String) -> Unit,
    onShare: (subject:String,text: String) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            DetailHeader(picture = item.Picture, onBack = onBack)
            Surface(color = Color.White,
                shape = RoundedCornerShape(topStart = 58.dp, topEnd = 50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 400.dp)
            ){
                DetailBody(
                    item = item,
                    onShare = onShare,
                    onSendSms = onSendSms,
                    onDial = onDial,
                    onDirection = onDirection)
            }
        }
    }

}

@Composable
fun DetailBody(
    item: doctorModel,
    onShare: (String, String) -> Unit,
    onSendSms: (String) -> Unit,
    onDial: (String) -> Unit,
    onDirection: (String) -> Unit
) {
    val darkPurple = colorResource(R.color.darkPurple)
    val gray = colorResource(R.color.gray)
    val lightPurple = colorResource(R.color.darkPurple)


    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ){
        Spacer(
            modifier = Modifier.height(24.dp)
        )
        Text(
        text = item.Name?:"",
            color = Color.Black,
            fontSize = 220.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp )
        )
        Text(
            text = item.Special?: "",
             color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier =
                Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ){
            Image(
                painter = painterResource(R.drawable.location),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = item.Location?:"",
                color = darkPurple,
                modifier = Modifier.weight(1f)
            )

        }
    }

}