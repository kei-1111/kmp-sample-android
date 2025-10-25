package io.github.kei_1111.kmp_sample_android.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.kei_1111.kmp_sample_android.core.designsystem.theme.KmpSampleAndroidTheme
import io.github.kei_1111.kmp_sample_android.feature.home.component.HomeTopBar
import io.github.kei_1111.kmp_sample_library.core.model.MarsProperty
import io.github.kei_1111.kmp_sample_library.core.model.PropertyType
import io.github.kei_1111.kmp_sample_library.feature.home.HomeAction
import io.github.kei_1111.kmp_sample_library.feature.home.HomeState
import io.github.kei_1111.kmp_sample_library.feature.home.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = state,
        onAction = viewModel::onAction,
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HomeTopBar(scrollBehavior = scrollBehavior)
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding()),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is HomeState.Init -> {
                    Text(text = "Welcome to Home Screen",)
                }

                is HomeState.Loading -> {
                    Text(text = "Loading...")
                }

                is HomeState.Error -> {
                    Text(text = "Error")
                }

                is HomeState.Stable -> {
                    HomeScreenContent(
                        state = state,
                        onAction = onAction,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

private data class HomeScreenPreviewParameter(
    val state: HomeState,
)

private class HomeScreenPPP : CollectionPreviewParameterProvider<HomeScreenPreviewParameter> (
    collection = listOf(
        HomeScreenPreviewParameter(
            state = HomeState.Init
        ),
        HomeScreenPreviewParameter(
            state = HomeState.Loading
        ),
        HomeScreenPreviewParameter(
            state = HomeState.Error(
                message = "Unknown Error"
            )
        ),
        HomeScreenPreviewParameter(
            state = HomeState.Stable(
                marsProperties = List(10) { index ->
                    MarsProperty(
                        id = index.toString(),
                        price = 1000 * (index + 1),
                        type = if (index % 2 == 0) PropertyType.RENT else PropertyType.BUY,
                        imgSrc = "",
                    )
                },
                selectedProperty = null,
            ),
        )
    )
)

@Composable
@Preview
private fun HomeScreenPreview(
    @PreviewParameter(HomeScreenPPP::class) parameter: HomeScreenPreviewParameter
) {
    KmpSampleAndroidTheme {
        HomeScreen(
            state = parameter.state,
            onAction = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
