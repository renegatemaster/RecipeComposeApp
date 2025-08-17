package com.renegatemaster.recipecomposeapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

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
    dynamicColor: Boolean = true,
    typography: Typography = MaterialTheme.typography,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> RecipesAppDarkColorScheme
        else -> RecipesAppLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}