package com.example.a30daysofrapmusic

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysofrapmusic.model.SongsDataSource
import com.example.a30daysofrapmusic.ui.theme._30DaysOfRapMusicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysOfRapMusicTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    _30DaysOfRapMusicApp()
                }
            }
        }
    }
    @SuppressLint("ComposableNaming")
    @Composable
    fun _30DaysOfRapMusicApp() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar()
            }
        ) {

            val songs = SongsDataSource.Songs
            SongsList(songs = songs, contentPadding = it)
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBar(modifier: Modifier = Modifier) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge,
                )
            },
            modifier = modifier
        )
    }

    @SuppressLint("ComposableNaming")
    @Preview(showBackground = true)
    @Composable
    fun _30DaysOfRapMusicThemePreview() {
        _30DaysOfRapMusicTheme {
            _30DaysOfRapMusicApp()
        }
    }
}

