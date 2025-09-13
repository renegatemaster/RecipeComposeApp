package com.renegatemaster.recipecomposeapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.renegatemaster.recipecomposeapp.data.repository.RecipesRepositoryStub
import com.renegatemaster.recipecomposeapp.ui.categories.CategoriesScreen
import com.renegatemaster.recipecomposeapp.ui.categories.model.toUiModel
import com.renegatemaster.recipecomposeapp.ui.favorites.FavoritesScreen
import com.renegatemaster.recipecomposeapp.ui.navigation.BottomNavigation
import com.renegatemaster.recipecomposeapp.ui.recipes.RecipeDetail
import com.renegatemaster.recipecomposeapp.ui.recipes.RecipesScreen
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme

@Composable
fun RecipesApp() {
    RecipeComposeAppTheme {
        var state by remember { mutableStateOf(AppScreens.CATEGORIES) }
        var selectedCategoryId by remember { mutableStateOf<Int?>(null) }
        var selectedCategoryTitle by remember { mutableStateOf("") }
        var selectedRecipeId by remember { mutableStateOf<Int?>(null) }

        Scaffold(bottomBar = {
            BottomNavigation(
                onCategoriesClick = { state = AppScreens.CATEGORIES },
                onFavoritesClick = { state = AppScreens.FAVORITES },
            )
        }
        ) { innerPadding ->
            when (state) {
                AppScreens.CATEGORIES -> {
                    val categories = RecipesRepositoryStub
                        .getCategories()
                        .map { it.toUiModel() }
                    CategoriesScreen(
                        modifier = Modifier.padding(innerPadding),
                        categories = categories,
                        onCategoryClick = { categoryId, categoryTitle ->
                            selectedCategoryId = categoryId
                            selectedCategoryTitle = categoryTitle
                            state = AppScreens.RECIPES
                        }
                    )
                }

                AppScreens.FAVORITES -> FavoritesScreen(
                    modifier = Modifier.padding(innerPadding)
                )

                AppScreens.RECIPES -> RecipesScreen(
                    categoryId = selectedCategoryId ?: error("Category ID is required"),
                    categoryTitle = selectedCategoryTitle,
                    modifier = Modifier.padding(innerPadding),
                    onRecipeClick = { recipeId: Int ->
                        selectedRecipeId = recipeId
                        state = AppScreens.RECIPE_DETAIL
                    }
                )

                AppScreens.RECIPE_DETAIL -> RecipeDetail(
                    recipeId = selectedRecipeId,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
