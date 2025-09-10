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
import com.renegatemaster.recipecomposeapp.ui.favorites.FavoritesScreen
import com.renegatemaster.recipecomposeapp.ui.navigation.BottomNavigation
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme

@Composable
fun RecipesApp() {
    RecipeComposeAppTheme {
        var state by remember { mutableStateOf(AppScreens.CATEGORIES) }
        Scaffold(bottomBar = {
            BottomNavigation(
                onCategoriesClick = { state = AppScreens.CATEGORIES },
                onFavoritesClick = { state = AppScreens.FAVORITES },
            )
        }
        ) { innerPadding ->
            when (state) {
                AppScreens.CATEGORIES -> {
                    val categories = RecipesRepositoryStub.getCategories()
                    CategoriesScreen(
                        modifier = Modifier.padding(innerPadding),
                        categories = categories
                    )
                }

                AppScreens.FAVORITES -> FavoritesScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
