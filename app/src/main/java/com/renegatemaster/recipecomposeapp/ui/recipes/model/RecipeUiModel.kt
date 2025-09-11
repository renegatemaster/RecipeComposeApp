package com.renegatemaster.recipecomposeapp.ui.recipes.model

import androidx.compose.runtime.Immutable
import com.renegatemaster.recipecomposeapp.Constants
import com.renegatemaster.recipecomposeapp.data.model.RecipeDto

@Immutable
data class RecipeUiModel(
    val id: Int,
    val title: String,
    val ingredients: List<IngredientUiModel>,
    val method: List<String>,
    val imageUrl: String,
    val isFavorite: Boolean,
)

fun RecipeDto.toUiModel() = RecipeUiModel(
    id = id,
    title = title,
    ingredients = ingredients.map { it.toUiModel() },
    method = method,
    imageUrl = Constants.ASSETS_URI_PREFIX + imageUrl,
    isFavorite = false, //TODO("logic for fav")
)