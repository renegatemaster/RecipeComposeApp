package com.renegatemaster.recipecomposeapp.ui.model

import androidx.compose.runtime.Immutable
import com.renegatemaster.recipecomposeapp.Constants
import com.renegatemaster.recipecomposeapp.data.model.CategoryDto

@Immutable
data class CategoryUiModel(
    val id: Int,
    val title: String,
    val imageUrl: String,
)

fun CategoryDto.toUiModel() = CategoryUiModel(
    id = id,
    title = title,
    imageUrl = Constants.ASSETS_URI_PREFIX + imageUrl
)