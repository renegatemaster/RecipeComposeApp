package com.renegatemaster.recipecomposeapp.ui.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.renegatemaster.recipecomposeapp.R
import com.renegatemaster.recipecomposeapp.data.repository.RecipesRepositoryStub
import com.renegatemaster.recipecomposeapp.ui.core.ScreenHeader
import com.renegatemaster.recipecomposeapp.ui.recipes.model.RecipeUiModel
import com.renegatemaster.recipecomposeapp.ui.recipes.model.toUiModel
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme

@Composable
fun RecipesScreen(
    categoryId: Int?,
    categoryTitle: String,
    modifier: Modifier,
) {
    var recipes by remember { mutableStateOf<List<RecipeUiModel>>(emptyList()) }
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(categoryId) {
        isLoading = true
        try {
            categoryId?.let {
                recipes = RecipesRepositoryStub
                    .getRecipesByCategoryId(it)
                    .map { dto -> dto.toUiModel() }
            }
        } finally {
            isLoading = false
        }
    }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ScreenHeader(
            header = categoryTitle,
            imageRes = R.drawable.img_error
        )
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(R.dimen.basicIndentation)
                ),
                contentPadding = PaddingValues(
                    dimensionResource(R.dimen.basicIndentation)
                )
            ) {
                itemsIndexed(recipes) { index, recipe ->
                    RecipeItem(
                        recipe = recipe,
                        onRecipeClick = { recipeId: Int ->
                        },
                        modifier = modifier
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    RecipeComposeAppTheme {
        Scaffold { innerPadding ->
            val categoryId = 0
            val categoryTitle = "Бургеры"
            val modifier = Modifier.padding(innerPadding)
            RecipesScreen(
                categoryId = categoryId,
                categoryTitle = categoryTitle,
                modifier = modifier,
            )
        }
    }
}