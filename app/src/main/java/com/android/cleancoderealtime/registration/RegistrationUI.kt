package com.android.cleancoderealtime.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.cleancoderealtime.R

@Composable
fun RegistrationScreenUI() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Row {
            IconButton(onClick = { /*TODO*/ }
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24), contentDescription = null)
            }
            Text(text = "Back", fontWeight = FontWeight.Bold, color = Color.Black, textAlign = TextAlign.Start, modifier = Modifier
                .padding(top = 15.dp)
                .clickable { TODO() })
        }
        Row {
            ThreeColoredCirclesWithText()
        }
        Row(modifier = Modifier.padding(top= 20.dp)) {
            UploadPhoto(R.drawable.baseline_photo_camera_24,Color.Gray,100.dp)
        }
        Column(modifier = Modifier.padding(30.dp)) {
            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Update value */ },
                label = { Text("I'm seeking a *") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Update value */ },
                label = { Text("First Name*") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Update value */ },
                label = { Text("Last Name*") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Update value */ },
                label = { Text("Email Address*") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = { /* TODO: Update value */ },
                label = { Text("Phone Number*") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Box(
                modifier = Modifier
                    .size(60.dp).align(Alignment.End)
                    .background(color = Color.Red, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                    contentDescription = null
                )
            }

        }
    }
}
@Composable
fun ColoredCircleWithText(
    color: Color,
    number: Int,
    text: String, circleColor: Color, textColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    var isSelected by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(100.dp)
            .clickable { onClick(); isSelected = !isSelected }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(circleColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number.toString(),
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else MaterialTheme.colorScheme.primary,

                )
        }
    }
}
@Composable
fun UploadPhoto(painterResource: Int, colorCircle: Color, size: Dp){
    Row {
        Box(
            modifier = Modifier
                .size(size)
                .background(color = colorCircle, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = painterResource),
                contentDescription = null
            )
        }
        Column(modifier = Modifier.padding(start = 15.dp,top=22.dp)) {
            Text(text = "Upload a Photo *", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.Black)
            Text(text = "Only visible to those you exchange photo with", fontSize = 12.sp , color = Color.Gray)
        }
    }
}

@Composable
fun ThreeColoredCirclesWithText() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        ColoredCircleWithText(color = Color.Black, number = 1, text = "Personal", circleColor = Color.Blue, textColor = Color.White, modifier = Modifier, onClick = {})
        HorizontalDivider()
        ColoredCircleWithText(color = Color.Red, number = 2, text = "About You", circleColor = Color.Gray, textColor = Color.White, modifier = Modifier, onClick = {})
        HorizontalDivider()
        ColoredCircleWithText(color = Color.Red, number = 3, text = "Account", circleColor = Color.Gray, textColor = Color.White, modifier = Modifier, onClick = {})
    }
}

@Composable
fun HorizontalDivider(
    color: Color = MaterialTheme.colorScheme.primary,
    thickness: Int = 2,
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = modifier
            .height(thickness.dp)
            .width(25.dp)
            .background(color = color)
    )
}


@Preview
@Composable
fun RegPrev(){
    RegistrationScreenUI()
}