package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFA7EBCA) // Pastel green background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFA7EBCA)), // Pastel green background
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ProfileSection()
        Spacer(modifier = Modifier.height(16.dp))
        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        ContactSection()
    }
}

@Composable
fun ProfileSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Replace 'R.drawable.ic_android_logo' with the correct resource ID for your logo
        Image(painter = painterResource(id = R.drawable.android_logo), contentDescription = "Logo")
        Text("Full Name", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Title", fontSize = 18.sp)
    }
}

@Composable
fun ContactSection() {
    Column {
        ContactItem(text = "+00 (00) 000 000", icon = R.drawable.ic_phone) // Replace with your actual phone icon resource
        ContactItem(text = "@socialmediahandle", icon = R.drawable.ic_twitter) // Replace with your actual Twitter icon resource
        ContactItem(text = "email@domain.com", icon = R.drawable.ic_email) // Replace with your actual email icon resource
    }
}

@Composable
fun ContactItem(text: String, icon: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // Replace with actual icon resource IDs
        Icon(painter = painterResource(id = icon), contentDescription = null, tint = Color.Unspecified)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}

