package com.renegatemaster.recipecomposeapp.ui.model

import androidx.compose.runtime.Immutable
import com.renegatemaster.recipecomposeapp.data.model.IngredientDto

@Immutable
data class IngredientUiModel(
    val name: String,
    val amount: String,
)

fun IngredientDto.toUiModel() = IngredientUiModel(
    name = description,
    amount = quantity,
)
