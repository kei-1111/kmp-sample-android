package io.github.kei_1111.kmp_sample_android.feature.home.component

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
import io.github.kei_1111.kmp_sample_android.feature.home.BuildConfig
import io.github.kei_1111.kmp_sample_library.feature.home.HomeUiAction
import io.github.kei_1111.kmp_sample_library.feature.home.HomeUiState
import io.github.kei_1111.kmp_sample_library.feature.home.model.MarsPropertyUiModel
import io.github.kei_1111.kmp_sample_library.feature.home.model.PropertyTypeUiModel

@Composable
fun HomeScreenContent(
    state: HomeUiState.Stable,
    onAction: (HomeUiAction) -> Unit,
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
        items(state.marsProperties) { marsPropertyUiModel ->
            MarsPropertyCard(
                marsPropertyUiModel = marsPropertyUiModel,
                onClick = { onAction(HomeUiAction.OnClickMarsPropertyCard(marsPropertyUiModel)) },
            )
        }
    }

    if (state.selectedProperty != null) {
        MarsPropertyDetailDialog(
            marsPropertyUiModel = state.selectedProperty!!,
            onDismiss = { onAction(HomeUiAction.OnDismissMarsPropertyDetailDialog) },
        )
    }
}

private data class HomeScreenContentPreviewParameter(
    val selectedPropertyUiModel: MarsPropertyUiModel?
)

private class HomeScreenContentPPP : CollectionPreviewParameterProvider<HomeScreenContentPreviewParameter> (
    collection = listOf(
        HomeScreenContentPreviewParameter(
            selectedPropertyUiModel = null,
        ),
        HomeScreenContentPreviewParameter(
            selectedPropertyUiModel = MarsPropertyUiModel(
                id = "49005",
                type = PropertyTypeUiModel.BUY,
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
            state = HomeUiState.Stable(
                marsProperties = List(10) { index ->
                    MarsPropertyUiModel(
                        id = index.toString(),
                        price = "$${1000 * (index + 1)}",
                        type = if (index % 2 == 0) PropertyTypeUiModel.BUY else PropertyTypeUiModel.RENT,
                        imageUrl = "${BuildConfig.DRAWABLE_PATH}/img_mars_preview.jpg",
                    )
                },
                selectedProperty = parameter.selectedPropertyUiModel,
            ),
            onAction = {},
        )
    }
}
