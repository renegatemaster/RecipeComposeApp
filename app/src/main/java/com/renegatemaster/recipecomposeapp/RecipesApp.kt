package com.renegatemaster.recipecomposeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme
import com.renegatemaster.recipecomposeapp.ui.theme.recipesAppTypography

@Composable
fun RecipesApp() {
    RecipeComposeAppTheme(
        typography = recipesAppTypography,
    ) {
        Scaffold ()
        { innerPadding ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Greeting(
                    name = "Android",
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = recipesAppTypography.displayLarge
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = recipesAppTypography.titleMedium
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = recipesAppTypography.bodyMedium
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = recipesAppTypography.bodySmall
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = recipesAppTypography.labelLarge
        )
    }
}