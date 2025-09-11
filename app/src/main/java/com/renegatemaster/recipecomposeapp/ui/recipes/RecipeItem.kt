package com.renegatemaster.recipecomposeapp.ui.recipes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.renegatemaster.recipecomposeapp.R
import com.renegatemaster.recipecomposeapp.ui.recipes.model.RecipeUiModel
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme

@Composable
fun RecipeItem(
    recipe: RecipeUiModel,
    onRecipeClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    RecipeComposeAppTheme {
        Card(
            modifier = modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable { onRecipeClick(recipe.id) },
            shape = RoundedCornerShape(
                size = dimensionResource(R.dimen.halfBasicCornerRadius)
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
            ) {
                AsyncImage(
                    model = recipe.imageUrl,
                    placeholder = painterResource(R.drawable.img_error),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = recipe.title.uppercase(),
                    modifier = Modifier.padding(dimensionResource(R.dimen.cardHeaderPadding)),
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeItemPreview() {
    val recipe = RecipeUiModel(
        id = 1,
        title = "Чизбургер",
        ingredients = emptyList(),
        method = emptyList(),
        imageUrl = "",
        isFavorite = true,
    )
    RecipeItem(
        recipe = recipe,
        onRecipeClick = {},
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}