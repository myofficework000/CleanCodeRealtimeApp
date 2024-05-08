package com.android.cleancoderealtime.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.cleancoderealtime.R
import com.android.cleancoderealtime.ui.theme.dp_10
import com.android.cleancoderealtime.ui.theme.dp_16
import com.android.cleancoderealtime.ui.theme.dp_18
import com.android.cleancoderealtime.ui.theme.dp_20
import com.android.cleancoderealtime.ui.theme.sp_30


@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword: Boolean by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier
            .background(color = White)
            .fillMaxSize()
    ) {
        Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(dp_10)
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    textAlign = TextAlign.Center,
                    fontSize = sp_30,
                    fontWeight = Bold,
                    fontStyle = FontStyle.Italic,
                    color = Blue,
                    modifier = Modifier.fillMaxWidth()
                )


        Spacer(modifier = Modifier.height(dp_18))
            SignInWithGoogleButton {

            }
            Spacer(modifier = Modifier.height(dp_18))
            Text(text = "________        OR        ________")

            Spacer(modifier = Modifier.height(dp_18))
            OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White),
                    value = email,
                    onValueChange = {
                        email = it
                        println("Email: $it")
                    },
                    label = { Text(stringResource(id = R.string.YourEmail)) },
                leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null
                        )
                    }
                )

                Spacer(modifier = Modifier.height(dp_16))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = { Text(stringResource(id = R.string.YourPassword)) },
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { showPassword = !showPassword }) {
                            Icon(
                                if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_lock_open_24),
                            contentDescription = null
                        )
                    }
                )

                Spacer(modifier = Modifier.height(dp_16))
                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(stringResource(id = R.string.login))
                }
            Text(text = stringResource(id = R.string.Forgotyourpassword), modifier = Modifier.clickable {
                })
            Text(text =stringResource(id = R.string.donthaveaccount), modifier = Modifier.clickable {
            })
            }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}

@Composable
fun SignInWithGoogleButton(onClick: () -> Unit) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = dp_20, end = dp_20),
        shape = RoundedCornerShape(dp_20),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Search",
                tint = Color.Black,
                modifier = Modifier.size(dp_20)

            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Sign in with Google",
                color = Color.Black
            )
        }

    }
}


