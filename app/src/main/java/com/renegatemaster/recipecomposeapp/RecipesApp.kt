package com.renegatemaster.recipecomposeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.renegatemaster.recipecomposeapp.ui.navigation.BottomNavigation
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme
import com.renegatemaster.recipecomposeapp.ui.theme.recipesAppTypography

@Composable
fun RecipesApp() {
    RecipeComposeAppTheme(
        typography = recipesAppTypography,
    ) {
        var state by remember { mutableStateOf(AppScreens.CATEGORIES) }
        Scaffold(bottomBar = {
            BottomNavigation(
                onCategoriesClick = { state = AppScreens.CATEGORIES },
                onFavoritesClick = { state = AppScreens.FAVORITES },
            )
        }
        ) { innerPadding ->
            when (state) {
                AppScreens.CATEGORIES -> Categories(
                    modifier = Modifier.padding(innerPadding)
                )

                AppScreens.FAVORITES -> Favorites(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
private fun Categories(modifier: Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Categories", modifier = modifier)
    }
}

@Composable
private fun Favorites(modifier: Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Favorites", modifier = modifier)
    }
}
