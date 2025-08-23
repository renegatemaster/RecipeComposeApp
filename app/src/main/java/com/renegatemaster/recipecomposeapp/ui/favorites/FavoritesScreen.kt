package com.renegatemaster.recipecomposeapp.ui.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.renegatemaster.recipecomposeapp.R
import com.renegatemaster.recipecomposeapp.ui.core.ScreenBody
import com.renegatemaster.recipecomposeapp.ui.core.ScreenHeader

@Composable
fun FavoritesScreen(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ScreenHeader(
            header = "favorites",
            imageRes = R.drawable.bcg_favorites
        )
        ScreenBody("There is no favorites yet")
    }
}