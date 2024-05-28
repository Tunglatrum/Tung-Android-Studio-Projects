package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp(modifier: Modifier = Modifier) {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result1 by remember { mutableIntStateOf(1) }
    var result2 by remember { mutableIntStateOf(1) }
    var result3 by remember { mutableIntStateOf(1) }

    val imageResource1 = getDiceImageResource(result1)
    val imageResource2 = getDiceImageResource(result2)
    val imageResource3 = getDiceImageResource(result3)



    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DiceImage(imageResource1)
            DiceImage(imageResource2)
            DiceImage(imageResource3)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(onClick = {
                when ((1..3).random()) {
                    1 -> result1 = (1..6).random()
                    2 -> result2 = (1..6).random()
                    3 -> result3 = (1..6).random()
                }
            }) {
                Text(text = stringResource(R.string.roll_single_dice), fontSize = 24.sp)
            }

            Button(onClick = {
                result1 = (1..6).random()
                result2 = (1..6).random()
                result3 = (1..6).random()
            }) {
                Text(text = stringResource(R.string.roll_all_dice), fontSize = 24.sp)
            }
        }
    }
}

@Composable
fun DiceImage(resourceId: Int) {
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = "Dice",
        modifier = Modifier.size(120.dp)
    )
}

@Composable
fun getDiceImageResource(result: Int): Int {
    return when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}
