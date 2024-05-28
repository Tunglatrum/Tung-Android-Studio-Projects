package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

val imageResources = listOf(R.drawable.artwork1, R.drawable.artwork2, R.drawable.artwork3)
val titleResources = listOf(R.string.image_title_1, R.string.image_title_2, R.string.image_title_3)
val artistResources = listOf(R.string.artist_1, R.string.artist_2, R.string.artist_3)
val yearResources = listOf(R.string.year_1, R.string.year_2, R.string.year_3)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}

@Composable
fun ArtSpaceLayout() {
    var currentIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Artwork Wall
        ArtworkImage(currentIndex)

        Spacer(modifier = Modifier.height(24.dp))

        // Artwork Descriptor
        ArtworkInfo(currentIndex)

        Spacer(modifier = Modifier.weight(1f))

        // Display Controller
        NavigationButtons(
            onPreviousClick = {
                currentIndex = if (currentIndex == 0) imageResources.size - 1 else currentIndex - 1
            },
            onNextClick = {
                currentIndex = (currentIndex + 1) % imageResources.size
            }
        )
    }
}

@Composable
fun ArtworkImage(currentIndex: Int) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .shadow(8.dp) // Add shadow for elevation
            .background(Color.White) // White background for the frame
            .padding(16.dp) // Increased padding for a bigger frame
            .border(4.dp, Color.LightGray) // Light gray border around the frame, increased width
    ) {
        Image(
            painter = painterResource(id = imageResources[currentIndex]),
            contentDescription = stringResource(id = titleResources[currentIndex]),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f), // Ensure the image maintains a consistent aspect ratio
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ArtworkInfo(currentIndex: Int) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray)
            .padding(8.dp), // Add padding to prevent clipping
        color = Color(0xFFBBDEFB) // Light blue background
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(stringResource(id = titleResources[currentIndex]))
                    }
                },
                fontSize = 28.sp, // Increased font size
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = buildAnnotatedString {
                    append(stringResource(id = artistResources[currentIndex]))
                    append(" (")
                    withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                        append(stringResource(id = yearResources[currentIndex]))
                    }
                    append(")")
                },
                fontSize = 20.sp, // Increased font size
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun NavigationButtons(onPreviousClick: () -> Unit, onNextClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onPreviousClick) {
            Text(stringResource(R.string.previous_button))
        }
        Button(onClick = onNextClick) {
            Text(stringResource(R.string.next_button))
        }
    }
}
