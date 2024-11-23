package com.example.dicerollerapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = PastelPink,
    secondary = PastelPurple,
    background = PastelYellow,
    onBackground = TextGray,
    surface = SoftWhite,
    onSurface = TextGray
)

@Composable
fun DiceRollerAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
