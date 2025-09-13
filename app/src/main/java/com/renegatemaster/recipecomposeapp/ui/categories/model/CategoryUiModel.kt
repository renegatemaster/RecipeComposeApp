package com.renegatemaster.recipecomposeapp.ui.categories.model

import androidx.compose.runtime.Immutable
import com.renegatemaster.recipecomposeapp.Constants
import com.renegatemaster.recipecomposeapp.data.model.CategoryDto
import kotlin.String

@Immutable
data class CategoryUiModel(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
)

fun CategoryDto.toUiModel() = CategoryUiModel(
    id = id,
    title = title,
    description = description,
    imageUrl = Constants.ASSETS_URI_PREFIX + imageUrl
)