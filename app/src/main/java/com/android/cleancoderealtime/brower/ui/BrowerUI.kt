package com.android.cleancoderealtime.brower.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.android.cleancoderealtime.R

data class User(val name: String, val age: Int, val location: String, val avatarId: Int)

@Composable
fun UserList(users: List<User>) {
    LazyColumn {
        items(users) { user ->
            UserRow(user)
        }
    }
}

@Composable
fun UserRow(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = user.avatarId),
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(16.dp))
                Column {
                    Text(text = "${user.name}, ${user.age}", style = MaterialTheme.typography.titleMedium)
                    Text(text = user.location, style = MaterialTheme.typography.bodySmall)
                }
            }
            Spacer(Modifier.height(8.dp))
            Row {
                Box(
                    modifier = Modifier
                        .height(36.dp)
                        .fillMaxWidth()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color.Blue, Color.Magenta, Color.Red)
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row {
                        Button(
                            onClick = { /* TODO: Save action */ },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            shape = RoundedCornerShape(0.dp)
                        ) {
                            Text("Save")
                        }
                        Spacer(Modifier.width(4.dp))
                        Button(
                            onClick = { /* TODO: Invite action */ },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            shape = RoundedCornerShape(0.dp)
                        ) {
                            Text("Invite")
                        }
                        Spacer(Modifier.width(4.dp))
                        Button(
                            onClick = { /* TODO: Message action */ },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            shape = RoundedCornerShape(0.dp)
                        ) {
                            Text("Message")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserList() {
    val sampleUsers = listOf(
        User("Mohammadhp", 21, "Qatar", R.drawable.avatar_placeholder),
        User("Abbasi", 25, "Qatar", R.drawable.avatar_placeholder),
        User("Maanshe", 29, "Somalia", R.drawable.avatar_placeholder),
        User("Muhammadshahzad", 25, "Qatar", R.drawable.avatar_placeholder)
    )
    MaterialTheme {
        UserList(sampleUsers)
    }
}