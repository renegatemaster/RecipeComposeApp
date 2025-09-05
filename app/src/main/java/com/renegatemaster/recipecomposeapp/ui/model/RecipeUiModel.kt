package com.renegatemaster.recipecomposeapp.ui.model

import androidx.compose.runtime.Immutable
import com.renegatemaster.recipecomposeapp.Constants
import com.renegatemaster.recipecomposeapp.data.model.RecipeDto
import com.renegatemaster.recipecomposeapp.data.repository.RecipesRepositoryStub

@Immutable
data class RecipeUiModel(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val categoryTitle: String,
)

fun RecipeDto.toUiModel() = RecipeUiModel(
    id = id,
    title = title,
    imageUrl = Constants.ASSETS_URI_PREFIX + imageUrl,
    categoryTitle = RecipesRepositoryStub.getCategoryByRecipeId(id)
)
