package com.android.cleancoderealtime.profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.android.cleancoderealtime.R
import com.android.cleancoderealtime.ui.theme.lightGray
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProfileUI(modifier: Modifier = Modifier) {

    Column(
        Modifier
            .fillMaxSize()
            .background(color = lightGray)
            .padding(20.dp)) {

        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Dreamer2",
            fontSize = 24.sp,
            fontWeight = Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp))

        Button(onClick = { /*TODO*/ },
            Modifier.fillMaxWidth()) {
            Icon(imageVector= Icons.Default.Edit,
                contentDescription = null,
                Modifier.padding(10.dp, 0.dp))
            Text(text = "Edit your profile")
        }

        Spacer(modifier = Modifier.size(20.dp))

        ProfileBlockUI()

        Spacer(modifier = Modifier.size(20.dp))

        AboutMeBlockUI()

    }

}

@Composable
fun ProfileBlockUI(modifier: Modifier = Modifier) {

        ConstraintLayout(
            modifier
                .background(color = Color.White)
                .padding(20.dp)
        )  {

            val (tv_Profile, divider, tvAge_label, tvAge_content,
                tvLocation_label, tvLocation_content,
                tvMRR_label, tvMRR_content,
                tvlastOL_label, tvLastOL_content) = createRefs()

            Text(
                text = "Profile",
                fontSize = 16.sp,
                fontWeight = SemiBold,
                modifier = Modifier
                    .constrainAs(tv_Profile){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            Divider(modifier = Modifier
                .constrainAs(divider) {
                    top.linkTo(tv_Profile.bottom)
                }
                .padding(0.dp, 20.dp))

            Text(
                text = "Age",
                fontSize = 12.sp,
                fontWeight = SemiBold,
                modifier = Modifier
                    .constrainAs(tvAge_label) {
                        top.linkTo(divider.bottom)
                        start.linkTo(parent.start)
                    }
                    .padding(10.dp))

            Text(
                text = "27",
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(tvAge_content) {
                        top.linkTo(divider.bottom)
                    }
                    .padding(180.dp, 10.dp, 0.dp, 0.dp))



            Text(
                text = "Location",
                fontSize = 12.sp,
                fontWeight = SemiBold,
                modifier = Modifier
                    .constrainAs(tvLocation_label) {
                        top.linkTo(tvAge_label.bottom)
                        start.linkTo(parent.start)
                    }
                    .padding(10.dp))

            Text(
                text = "Al Wakrah, Qatar",
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(tvLocation_content) {
                        top.linkTo(tvAge_label.bottom)
                    }
                    .padding(180.dp, 10.dp, 0.dp, 0.dp))




            Text(
                text = "Message Response Rate",
                fontSize = 12.sp,
                fontWeight = SemiBold,
                modifier = Modifier
                    .constrainAs(tvMRR_label) {
                        top.linkTo(tvLocation_content.bottom)
                        start.linkTo(parent.start)
                    }
                    .padding(10.dp))

            Text(
                text = "0.0%",
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(tvMRR_content) {
                        top.linkTo(tvLocation_content.bottom)
                    }
                    .padding(180.dp, 10.dp, 0.dp, 0.dp))




            Text(
                text = "Last Seen Online",
                fontSize = 12.sp,
                fontWeight = SemiBold,
                modifier = Modifier
                    .constrainAs(tvlastOL_label) {
                        top.linkTo(tvMRR_content.bottom)
                        start.linkTo(parent.start)
                    }
                    .padding(10.dp))

            Text(
                text = "A few seconds ago",
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(tvLastOL_content) {
                        top.linkTo(tvMRR_content.bottom)
                    }
                    .padding(180.dp, 10.dp, 0.dp, 0.dp))
        }

}


@Composable
fun AboutMeBlockUI(modifier: Modifier = Modifier) {

    ConstraintLayout(
        modifier
            .background(color = Color.White)
            .padding(20.dp)
    )  {

        val (tv_AboutMe, divider, tvPersonality) = createRefs()

        Text(
            text = "About Me",
            fontSize = 16.sp,
            fontWeight = SemiBold,
            modifier = Modifier
                .constrainAs(tv_AboutMe){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

        Divider(modifier = Modifier
            .constrainAs(divider) {
                top.linkTo(tv_AboutMe.bottom)
            }
            .padding(0.dp, 20.dp))

        Text(
            text = "Very shy",
            fontSize = 12.sp,
            modifier = Modifier
                .constrainAs(tvPersonality) {
                    top.linkTo(divider.bottom)
                    start.linkTo(parent.start)
                }
                .padding(10.dp))

    }
}


@Preview
@Composable
private fun ProfileUIPrev() {
    ProfileUI()
}

@Preview
@Composable
private fun ProfileBlockUIPrev() {
    ProfileBlockUI()
}


@Preview
@Composable
private fun AboutMePrev() {
    AboutMeBlockUI()
}