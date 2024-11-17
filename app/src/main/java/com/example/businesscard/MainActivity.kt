package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Scaffold(
                    content = { paddingValues ->
                        BusinessCardScreen(modifier = Modifier.padding(paddingValues))
                    }
                )
            }
        }
    }
}

@Composable
fun ProfilePicture(
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.prof)
    Box(
        modifier = modifier
            .padding(16.dp)
            .size(150.dp)
            .clip(CircleShape)
    ) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.profile_picture_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun UserDetails(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
    ) {
        ProfilePicture()
        Text(
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = role,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ContactDetails(
    phone: String,
    instagram: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_phone),
                contentDescription = stringResource(R.string.phone_icon_description),
                modifier = Modifier.size(24.dp).padding(end = 8.dp)
            )
            Text(
                text = stringResource(R.string.phone_label, phone),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_ig),
                contentDescription = stringResource(R.string.instagram_icon_description),
                modifier = Modifier.size(24.dp).padding(end = 8.dp)
            )
            Text(
                text = stringResource(R.string.instagram_label, instagram),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_email),
                contentDescription = stringResource(R.string.email_icon_description),
                modifier = Modifier.size(24.dp).padding(end = 8.dp)
            )
            Text(
                text = stringResource(R.string.email_label, email),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            UserDetails(name = "Greater", role = "Student")
            ContactDetails(
                phone = "0939425399",
                instagram = "plinphon",
                email = "greatez12345@gmail.com"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}
