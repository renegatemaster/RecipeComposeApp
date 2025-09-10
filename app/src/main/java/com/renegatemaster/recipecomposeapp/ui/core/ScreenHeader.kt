package com.renegatemaster.recipecomposeapp.ui.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.renegatemaster.recipecomposeapp.R

@Composable
fun ScreenHeader(header: String, imageRes: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(224.dp),
        contentAlignment = Alignment.BottomStart,
    ) {
        AsyncImage(
            model = imageRes,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Surface(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(dimensionResource(R.dimen.basicIndentation)),
            shape = RoundedCornerShape(
                dimensionResource(R.dimen.basicCornerRadius)
            ),
            color = MaterialTheme.colorScheme.background,
        ) {
            Text(
                text = header.uppercase(),
                modifier = Modifier.padding(dimensionResource(R.dimen.headerPadding)),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenHeaderPreview() {
    ScreenHeader(
        header = "categories",
        imageRes = R.drawable.bcg_categories
    )
}