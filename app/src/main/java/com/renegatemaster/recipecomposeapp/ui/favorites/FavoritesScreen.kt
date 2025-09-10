package com.renegatemaster.recipecomposeapp.ui.favorites

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

@Composable
fun FavoritesScreen(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ScreenHeader(
            header = "favorites",
            imageRes = R.drawable.bcg_favorites
        )
        ScreenBody("There is no favorites yet")
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    RecipeComposeAppTheme {
        Scaffold() { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            FavoritesScreen(modifier)
        }
    }
}