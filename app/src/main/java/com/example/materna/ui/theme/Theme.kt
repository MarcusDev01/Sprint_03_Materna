package com.example.materna.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val MaternaColorScheme = lightColorScheme(
    primary = MaternaBlue,
    secondary = MaternaYellow,
    background = MaternaBackground,
    surface = MaternaSurface,
    onPrimary = MaternaSurface,
    onBackground = MaternaTextPrimary,
    onSurface = MaternaTextPrimary
)

@Composable
fun MaternaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MaternaColorScheme,
        typography = Typography,
        content = content
    )
}
