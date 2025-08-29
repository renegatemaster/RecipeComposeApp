package com.renegatemaster.recipecomposeapp.ui.recipes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.renegatemaster.recipecomposeapp.R
import com.renegatemaster.recipecomposeapp.ui.core.ScreenBody
import com.renegatemaster.recipecomposeapp.ui.core.ScreenHeader
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme
import com.renegatemaster.recipecomposeapp.ui.theme.recipesAppTypography

@Composable
fun RecipesScreen(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ScreenHeader(
            header = "recipes",
            imageRes = R.drawable.img_error
        )
        ScreenBody("There will be recipes soon")
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    RecipeComposeAppTheme(
        typography = recipesAppTypography,
    ) {
        Scaffold() { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            RecipesScreen(modifier)
        }
    }
}