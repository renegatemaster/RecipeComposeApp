package com.renegatemaster.recipecomposeapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val RecipesAppLightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    secondary = AccentColor,
    tertiary = AccentBlue,
    outline = SliderTrackColor,
    background = BackgroundColor,
    surface = SurfaceColor,
    surfaceVariant = SurfaceVariantColor,
    outlineVariant = DividerColor,
    onPrimary = TextPrimaryColor,
    onSecondary = TextSecondaryColor,
)

private val RecipesAppDarkColorScheme = darkColorScheme(
    primary = PrimaryColorDark,
    secondary = AccentColorDark,
    tertiary = AccentBlueDark,
    outline = SliderTrackColorDark,
    background = BackgroundColorDark,
    surface = SurfaceColorDark,
    onPrimary = TextPrimaryColorDark,
    onSecondary = TextSecondaryColorDark,
)

@Composable
fun RecipeComposeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: Typography = recipesAppTypography,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) RecipesAppDarkColorScheme else RecipesAppLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}