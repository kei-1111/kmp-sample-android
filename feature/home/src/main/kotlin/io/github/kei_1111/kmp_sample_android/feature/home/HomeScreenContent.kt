package io.github.kei_1111.kmp_sample_android.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import io.github.kei_1111.kmp_sample_android.core.designsystem.theme.KmpSampleAndroidTheme
import io.github.kei_1111.kmp_sample_android.feature.home.component.MarsPropertyCard
import io.github.kei_1111.kmp_sample_android.feature.home.component.MarsPropertyDetailDialog
import io.github.kei_1111.kmp_sample_library.feature.home.HomeAction
import io.github.kei_1111.kmp_sample_library.feature.home.HomeState
import io.github.kei_1111.kmp_sample_library.feature.home.model.MarsPropertyUiModel

@Composable
fun HomeScreenContent(
    state: HomeState.Stable,
    onAction: (HomeAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    val navigationBarHeight = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    LazyVerticalGrid (
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier,
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            bottom = navigationBarHeight
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(state.marsProperties) { marsProperty ->
            MarsPropertyCard(
                marsProperty = marsProperty,
                onClick = { onAction(HomeAction.OnClickMarsPropertyCard(marsProperty)) },
            )
        }
    }

    if (state.selectedProperty != null) {
        MarsPropertyDetailDialog(
            marsProperty = state.selectedProperty!!,
            onDismiss = { onAction(HomeAction.OnDismissMarsPropertyDetailDialog) },
        )
    }
}

private data class HomeScreenContentPreviewParameter(
    val selectedProperty: MarsPropertyUiModel?
)

private class HomeScreenContentPPP : CollectionPreviewParameterProvider<HomeScreenContentPreviewParameter> (
    collection = listOf(
        HomeScreenContentPreviewParameter(
            selectedProperty = null,
        ),
        HomeScreenContentPreviewParameter(
            selectedProperty = MarsPropertyUiModel(
                id = "49005",
                type = "RENT",
                price = "$250,000",
                imageUrl = "${BuildConfig.DRAWABLE_PATH}/img_mars_preview.jpg",
            )
        )
    )
)

@Composable
@Preview
private fun HomeScreenContentPreview(
    @PreviewParameter(HomeScreenContentPPP::class) parameter: HomeScreenContentPreviewParameter
) {
    KmpSampleAndroidTheme {
        HomeScreenContent(
            state = HomeState.Stable(
                marsProperties = List(10) { index ->
                    MarsPropertyUiModel(
                        id = index.toString(),
                        price = "$${1000 * (index + 1)}",
                        type = if (index % 2 == 0) "RENT" else "BUY",
                        imageUrl = "${BuildConfig.DRAWABLE_PATH}/img_mars_preview.jpg",
                    )
                },
                selectedProperty = parameter.selectedProperty,
            ),
            onAction = {},
        )
    }
}
