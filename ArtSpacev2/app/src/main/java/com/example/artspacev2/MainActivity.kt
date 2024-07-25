package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Preview(showBackground = true, device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}

@Composable
fun ArtSpaceLayout() {
    var currentImageUrl by remember { mutableStateOf("") }
    var inputUrl by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ArtworkImage(imageUrl = currentImageUrl)

        Spacer(modifier = Modifier.height(24.dp))

        UrlInputField(
            inputUrl = inputUrl,
            onUrlChange = { inputUrl = it }
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { currentImageUrl = inputUrl },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Load Image")
        }
    }
}

@Composable
fun ArtworkImage(imageUrl: String) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .shadow(8.dp)
            .background(Color.White)
            .padding(16.dp)
            .border(4.dp, Color.LightGray)
    ) {
        if (imageUrl.isNotBlank()) {
            Image(
                painter = rememberImagePainter(data = imageUrl),
                contentDescription = "Artwork",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        } else {
            Text(
                text = "Enter a URL to load an image",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun UrlInputField(inputUrl: String, onUrlChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .border(1.dp, Color.Gray)
            .padding(8.dp)
    ) {
        BasicTextField(
            value = inputUrl,
            onValueChange = onUrlChange,
            modifier = Modifier
