package com.renegatemaster.recipecomposeapp.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.renegatemaster.recipecomposeapp.R
import com.renegatemaster.recipecomposeapp.ui.theme.RecipeComposeAppTheme

@Composable
fun BottomNavigation(
    onCategoriesClick: () -> Unit,
    onFavoritesClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(dimensionResource(R.dimen.halfBasicIndentation)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            onClick = onCategoriesClick,
            modifier = Modifier
                .padding(
                    start = dimensionResource(R.dimen.halfBasicIndentation),
                    end = dimensionResource(R.dimen.quarterBasicIndentation)
                )
                .weight(1f),
            shape = RoundedCornerShape(
                dimensionResource(R.dimen.halfBasicIndentation)
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
        ) {
            Text(
                text = "categories".uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.surface,
            )
        }
        Button(
            onClick = onFavoritesClick,
            modifier = Modifier
                .padding(
                    end = dimensionResource(R.dimen.halfBasicIndentation),
                )
                .weight(1f),
            shape = RoundedCornerShape(
                dimensionResource(R.dimen.halfBasicIndentation)
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
        ) {
            Text(
                text = "favorites".uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.surface,
            )
            AsyncImage(
                model = R.drawable.ic_heart_empty,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(24.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    RecipeComposeAppTheme {
        BottomNavigation(
            {}, {}
        )
    }
}