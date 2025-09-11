package com.renegatemaster.recipecomposeapp.ui.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme

@Composable
fun CategoryItem(
    imageRes: Any,
    header: String,
    description: String,
    onClick: () -> Unit,
) {
    RecipeComposeAppTheme {
        Card(
            modifier = Modifier
                .height(220.dp)
                .width(156.dp),
            shape = RoundedCornerShape(
                size = dimensionResource(R.dimen.halfBasicCornerRadius)
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                AsyncImage(
                    model = imageRes,
                    placeholder = painterResource(R.drawable.img_placeholder),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = header.uppercase(),
                    modifier = Modifier.padding(dimensionResource(R.dimen.cardHeaderPadding)),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = description,
                    maxLines = 3,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(R.dimen.cardHeaderPadding),
                            end = dimensionResource(R.dimen.cardHeaderPadding),
                            bottom = dimensionResource(R.dimen.cardHeaderPadding)
                        )
                        .height(50.dp),
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    val imageRes = R.drawable.img_error
    CategoryItem(
        imageRes = imageRes,
        header = "Бургеры",
        description = "Рецепты всех популярных видов бургеров",
    ) {}
}