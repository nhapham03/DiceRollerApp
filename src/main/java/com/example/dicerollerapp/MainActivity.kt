package com.example.dicerollerapp

import android.os.Bundle
import android.media.MediaPlayer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppTheme {
                DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // MediaPlayer for sound effects
    val context = LocalContext.current
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.roll_dice) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Dice Image
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString(),
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Roll Button
        Button(
            onClick = {
                result = (1..6).random() // Generate a random dice roll
                mediaPlayer.seekTo(0)   // Reset sound to start
                mediaPlayer.start()     // Play dice roll sound
            },
            modifier = Modifier
                .padding(16.dp)
                .height(60.dp)
                .width(200.dp),
            shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp) // Rounded edges
        ) {
            Text(
                text = stringResource(R.string.roll),
                color = Color.White,
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 24.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerAppPreview() {
    DiceRollerAppTheme {
        DiceRollerApp()
    }
}
