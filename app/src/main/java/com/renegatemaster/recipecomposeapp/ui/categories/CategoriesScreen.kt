package com.renegatemaster.recipecomposeapp.ui.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.renegatemaster.recipecomposeapp.R
import com.renegatemaster.recipecomposeapp.data.repository.RecipesRepositoryStub
import com.renegatemaster.recipecomposeapp.ui.categories.model.CategoryUiModel
import com.renegatemaster.recipecomposeapp.ui.categories.model.toUiModel
import com.renegatemaster.recipecomposeapp.ui.core.ScreenHeader
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme

@Composable
fun CategoriesScreen(modifier: Modifier, categories: List<CategoryUiModel>) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ScreenHeader(
            header = "categories",
            imageRes = R.drawable.bcg_categories
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.basicIndentation)
            ),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.basicIndentation)
            ),
            contentPadding = PaddingValues(
                dimensionResource(R.dimen.basicIndentation)
            )
        ) {
            itemsIndexed(categories) { index, category ->
                CategoryItem(
                    imageRes = category.imageUrl,
                    header = category.title,
                    description = category.description,
                ) { }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    RecipeComposeAppTheme {
        Scaffold { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            val categories = RecipesRepositoryStub
                .getCategories()
                .map { it.toUiModel() }
            CategoriesScreen(modifier, categories)
        }
    }
}