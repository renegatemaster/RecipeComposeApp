package com.renegatemaster.recipecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme
import com.renegatemaster.recipecomposeapp.ui.theme.recipesAppTypography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeComposeAppTheme(
                typography = recipesAppTypography,
            ) {
                Scaffold { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecipeComposeAppPreview() {
    RecipeComposeAppTheme(
        typography = recipesAppTypography,
    ) {
        Scaffold { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}