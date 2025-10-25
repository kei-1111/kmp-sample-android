package io.github.kei_1111.kmp_sample_android.feature.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import io.github.kei_1111.kmp_sample_library.feature.home.HomeAction
import io.github.kei_1111.kmp_sample_library.feature.home.HomeState

@Composable
fun HomeScreenContent(
    state: HomeState.Success,
    onAction: (HomeAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = WindowInsets.navigationBars.asPaddingValues()
    ) {
        items(state.marsProperties) { marsProperty ->
            AsyncImage(
                model = marsProperty.imgSrc,
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}