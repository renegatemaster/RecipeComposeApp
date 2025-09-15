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
import com.renegatemaster.recipecomposeapp.ui.recipes.model.RecipeUiModel
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme

@Composable
fun RecipeDetail(recipeId: Int?, modifier: Modifier) {
    //TODO(recipe receiving logic)
    val recipe = RecipeUiModel(
        id = recipeId ?: 0,
        title = "some recipe",
        ingredients = emptyList(),
        method = emptyList(),
        imageUrl = "",
        isFavorite = false
    )
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ScreenHeader(
            header = recipe.title,
            imageRes = R.drawable.img_error
        )
        ScreenBody(
            "UI in progress"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailPreview() {
    RecipeComposeAppTheme {
        Scaffold { innerPadding ->
            val recipeId = 0
            RecipeDetail(
                recipeId = recipeId,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}